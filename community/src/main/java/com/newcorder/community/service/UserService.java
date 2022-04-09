package com.newcorder.community.service;

import com.mysql.cj.log.Log;
import com.newcorder.community.dao.LoginTicketMapper;
import com.newcorder.community.dao.UserMapper;
import com.newcorder.community.entity.LoginTicket;
import com.newcorder.community.entity.User;
import com.newcorder.community.util.CommunityConstant;
import com.newcorder.community.util.CommunityUtil;
import com.newcorder.community.util.MailClient;
import com.newcorder.community.util.RedisKeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserService implements CommunityConstant {

    @Autowired
    private RedisTemplate redisTemplate;
    private final UserMapper userMapper;

    private final MailClient mailClient;

    private final TemplateEngine templateEngine;

//    private final LoginTicketMapper loginTicketMapper;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${community.path.domain}")
    private String domain;

    @Autowired
    public UserService(/*LoginTicketMapper loginTicketMapper,*/ TemplateEngine templateEngine, MailClient mailClient, UserMapper userMapper) {
//        this.loginTicketMapper = loginTicketMapper;
        this.templateEngine = templateEngine;
        this.mailClient = mailClient;
        this.userMapper = userMapper;
    }

    public LoginTicket findLoginTicket(String ticket) {
        String redisKey = RedisKeyUtil.getTicketKey(ticket);
        return (LoginTicket) redisTemplate.opsForValue().get(redisKey);
    }

    public void logout(String ticket) {
//        staus = 1表示凭证失效
//        loginTicketMapper.updateStatus(ticket, 1);
//        取出来重新设置ticket状态，再设回去
        String redisKey = RedisKeyUtil.getTicketKey(ticket);
        LoginTicket loginTicket = (LoginTicket) redisTemplate.opsForValue().get(redisKey);
        loginTicket.setStatus(1);
        redisTemplate.opsForValue().set(ticket, loginTicket);

    }

    //    expiredSecond过期时间
    public Map<String, Object> login(String username, String password, int expiredSeconds) {
        HashMap<String, Object> map = new HashMap<>();

//        空值处理
        if (StringUtils.isBlank(username)) {
            map.put("usernameMsg", "账号不能为空");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空");
            return map;
        }
//        合法性验证
        User user = userMapper.selectByName(username);
        System.out.println(user);
        if (user != null) {
            if (user.getStatus() == 0) {
                map.put("usernameMsg", "该账号未激活");
            }
            String userPassword = user.getPassword();
            String checkoutPwd = CommunityUtil.md5(password + user.getSalt());
            if (userPassword.equals(CommunityUtil.md5(password + user.getSalt()))) {
//                生成登录凭证
                LoginTicket loginTicket = new LoginTicket();
                loginTicket.setUserId(user.getId());
                loginTicket.setTicket(CommunityUtil.generateUUID());
                loginTicket.setStatus(0);
                loginTicket.setExpired(new Date(System.currentTimeMillis() + expiredSeconds * 1000L));
//                loginTicketMapper.insertLoginTicket(loginTicket);
                String redisKey = RedisKeyUtil.getTicketKey(loginTicket.getTicket());
//                loginTicket会被序列化成字符串
                redisTemplate.opsForValue().set(redisKey, loginTicket);
//                成功时候返回的map值
                map.put("ticket", loginTicket.getTicket());
            } else {
                map.put("passwordMsg", "密码错误");
            }
        } else {
            map.put("usernameMsg", "账号不存在");
        }
        return map;
    }

    public int activation(int userId, String code) {
        int activationStatus = 0;
        User user = userMapper.selectById(userId);
        if (user.getStatus() == 1) {
            activationStatus = ACTIVATION_REPEAT;
        } else if (user.getActivationCode().equals(code)) {
            userMapper.updateStatus(userId, 1); //设置激活状态
            clearCache(userId);
            activationStatus = ACTIVATION_SUCCESS;
        } else {
            activationStatus = ACTIVATION_FAIL;
        }
        return activationStatus;
    }

    public Map<String, Object> register(User user) {
        HashMap<String, Object> map = new HashMap<>();
//        空值处理
        if (user == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
//        业务上的漏洞，不是程序异常
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMsg", "账号不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMsg", "密码不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("emailMsg", "邮箱不能为空");
            return map;
        }
//        验证账号
        User u = userMapper.selectByName(user.getUsername());
        if (u != null) {
            map.put("usernameMsg", "该账号已经存在!");
            return map;
        }
//        验证邮箱
        u = userMapper.selectByName(user.getEmail());
        if (u != null) {
            map.put("emailMsg", "该邮箱已被注册!");
            return map;
        }
//        注册用户
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
//        后端对密码进行加密处理
        user.setPassword(CommunityUtil.md5(user.getPassword() + user.getSalt()));
        user.setType(0); //用户类型（普通用户）
        user.setStatus(0);// 是否激活
        user.setActivationCode(CommunityUtil.generateUUID());//激活码
        user.setHeaderUrl(String.format("http://images.newcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        System.out.println(user);
//        这个insertUser事实上功能并未完善，insert语句中并没有插入邮箱，导致邮箱插入为空（激活这里依然有小部分bug，不过只是个demo，有空再改进）
        userMapper.insertUser(user);


//        激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail()); //不是太理解？？？
        // url :http://localhost:8080/community/activation/(用户id)/(激活码）
        String url = domain + contextPath + "/activation/" + user.getId() + "/" + user.getActivationCode();
        System.out.println(url);
        context.setVariable("url", url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号", content);


        return map;
    }

    //    优化采数据
    public User findUserById(int id) {
//        return userMapper.selectById(id);
        User user = getCache(id);
        if (user == null) {
            user = initCache(id);
        }
        return user;
    }

    public int updateHeader(int userId, String headerUrl) {
        int rows = userMapper.updateHeader(userId, headerUrl);
        clearCache(userId);
        return rows;
    }

    public User findByName(String username) {
        return userMapper.selectByName(username);
    }

    public int updatePassword(int id, String password) {
        return userMapper.updatePassword(id, password);
    }


    //  1.  优先从缓存中取值
    private User getCache(int userId) {
        String redisKey = RedisKeyUtil.getUserKey(userId);
        return (User) redisTemplate.opsForValue().get(redisKey);
    }

    //    2.取不到时初始化缓存数据
    private User initCache(int userId) {
        User user = userMapper.selectById(userId);
        String redisKey = RedisKeyUtil.getUserKey(userId);
        redisTemplate.opsForValue().set(redisKey, user, 3600, TimeUnit.SECONDS);
        return user;
    }

    //    3.数据变更时清除缓存数据(update delete insert就清缓存）
    private void clearCache(int userId) {
        String redisKey = RedisKeyUtil.getUserKey(userId);
        redisTemplate.delete(redisKey);
    }
}
