package com.newcorder.community.controller;

import com.google.code.kaptcha.Producer;
import com.newcorder.community.entity.LoginTicket;
import com.newcorder.community.entity.User;
import com.newcorder.community.service.UserService;
import com.newcorder.community.util.CommunityConstant;
import com.newcorder.community.util.CommunityUtil;
import com.newcorder.community.util.RedisKeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController implements CommunityConstant {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private Producer kaptchaProducer;
    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(path = "/login", method = RequestMethod.POST)//有传数据ticket，用 post请求
//    传入的值一般都是前端的值,session是验证码,获得登录凭证
    public String getTicket(Model model, String username, String password, String code,
                            boolean rememberMe, HttpSession session, HttpServletResponse response,
                            @CookieValue("kaptchaOwner") String kaptchaOwner) {
        String kaptcha = (String) session.getAttribute("kaptcha");
        if (StringUtils.isNoneBlank(kaptchaOwner)) {
            String redisKey = RedisKeyUtil.getKaptchaKey(kaptchaOwner);
            kaptcha = (String) redisTemplate.opsForValue().get(redisKey);
        }
//        验证码忽略大小写kaptcha.equalsIgnoreCase(code))
        boolean flag1 = StringUtils.isBlank(kaptcha);
        boolean flag2 = StringUtils.isBlank(code);
        boolean flag3 = kaptcha.equalsIgnoreCase(code);
        if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !kaptcha.equalsIgnoreCase(code)) {
            model.addAttribute("codeMsg", "验证码不正确");
            return "site/login";
        }

//        检查账号,密码
        int expiredSeconds = rememberMe ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;

        Map<String, Object> map = userService.login(username, password, expiredSeconds);
        if (map.containsKey("ticket")) {
//            凭证存在
            Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
            cookie.setPath(contextPath);
            cookie.setMaxAge(expiredSeconds);
            response.addCookie(cookie);
            return "redirect:/index";//重定向到首页
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            return "/site/login";
        }
    }


    //    对这里做优化
    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response/*, HttpSession session*/) {
//        验证码应该放在服务端，否则容易被盗用
//        生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);
//        将验证码传入session
//        session.setAttribute("kaptcha", text);

//        验证码的归属
        String kaptchaOwner = CommunityUtil.generateUUID();
        Cookie cookie = new Cookie("kaptchaOwner", kaptchaOwner);
//        设置cookie有效时间 s
        cookie.setMaxAge(120);
        cookie.setPath(contextPath);
        response.addCookie(cookie);
//        将验证码存入redis
        String redisKey = RedisKeyUtil.getKaptchaKey(kaptchaOwner);
        redisTemplate.opsForValue().set(redisKey, text, 120, TimeUnit.SECONDS);

//        将图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();//这个流不用关闭
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            logger.error("响应验证码失败" + e.getMessage());

        }
    }

////    对这里做优化
//    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
//    public void getKaptcha(HttpServletResponse response, HttpSession session) {
////        验证码应该放在服务端，否则容易被盗用
////        生成验证码
//        String text = kaptchaProducer.createText();
//        BufferedImage image = kaptchaProducer.createImage(text);
////        将验证码传入session
//        session.setAttribute("kaptcha", text);
////        将图片输出给浏览器
//        response.setContentType("image/png");
//        try {
//            OutputStream os = response.getOutputStream();//这个流不用关闭
//            ImageIO.write(image, "png", os);
//        } catch (IOException e) {
//            logger.error("响应验证码失败" + e.getMessage());
//
//        }
//    }

    // url :http://localhost:8080/community/activation/(用户id)/(激活码）实际上是一个查询的行为
    @RequestMapping(path = "/activation/{userId}/{code}", method = RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId, @PathVariable("code") String code) {
        int activationResult = userService.activation(userId, code);
        if (activationResult == ACTIVATION_SUCCESS) {
            model.addAttribute("msg", "激活成功，您的账号已经可以正常使用了");
            model.addAttribute("target", "/login");

        } else if (activationResult == ACTIVATION_REPEAT) {
            model.addAttribute("msg", "无效操作，该账号已经激活过了");
            model.addAttribute("target", "/index"); //在前端输入RequestMapping的路径

        } else {
            model.addAttribute("msg", "激活失败，您提供的激活码不正确");
            model.addAttribute("target", "/index");

        }
        return "site/operate-result";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(Model model, User user) {
        System.out.println(user);
        Map<String, Object> map = userService.register(user);
        if (map == null || map.isEmpty()) {
            // 传值给前端的 "msg","target"
            model.addAttribute("msg", "注册成功,我们已经向您的邮箱发送了一封激活邮件");
            model.addAttribute("target", "index");
            return "site/operate-result";
        } else {
            //传值给前端的 "usernameMsg","passwordMsg","emailMsg"
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            model.addAttribute("emailMsg", map.get("emailMsg"));
            return "site/register";
        }

    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "site/login";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "site/register";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(@CookieValue("ticket") String ticket) {
        userService.logout(ticket);
//        退出时清理SecurityContextholder的内容
//        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }
}
