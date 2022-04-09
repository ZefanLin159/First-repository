package com.newcorder.community.controller;

import com.newcorder.community.annotation.LoginRequired;
import com.newcorder.community.entity.User;
import com.newcorder.community.service.FollowService;
import com.newcorder.community.service.LikeService;
import com.newcorder.community.service.UserService;
import com.newcorder.community.util.CommunityConstant;
import com.newcorder.community.util.CommunityUtil;
import com.newcorder.community.util.HostHolder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController implements CommunityConstant {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //    注入路径和域名
    @Value("${community.path.upload}")
    private String uploadPath;

    @Value("${community.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private final UserService userService;
    private final HostHolder hostHolder;
    private final LikeService likeService;
    private final FollowService followService;

    public UserController(UserService userService, HostHolder hostHolder, LikeService likeService,
                          FollowService followService) {
        this.userService = userService;
        this.hostHolder = hostHolder;
        this.likeService = likeService;
        this.followService = followService;
    }


    @LoginRequired
    @RequestMapping(path = "/setting", method = RequestMethod.GET)
    public String getSettingPage() {

        return "site/setting";
    }

    /*上传头像*/
    @LoginRequired
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String uploadHeader(MultipartFile headerImage, Model model) {
//        如果为空，必然是前端没有传值
        if (headerImage == null) {
            model.addAttribute("error", "您还没有选择图片");
            return "site/setting";
        }
        String filename = headerImage.getOriginalFilename();
        String suffix = null;
        if (filename != null) {
            suffix = filename.substring(filename.lastIndexOf("."));
        }
        if (StringUtils.isBlank(suffix)) {
            model.addAttribute("error", "文件格式不正确");
            return "/site/setting";
        }
//        生成随机文件名
        filename = CommunityUtil.generateUUID() + suffix;
//        确定文件存放的路径
        File dest = new File(uploadPath + "/" + filename);
        try {
            headerImage.transferTo(dest);
        } catch (IOException e) {
            logger.error("上传文件失败" + e.getMessage());
            throw new RuntimeException("上传文件失败，服务器发生异常", e);
        }

//        更新当前用户的头像路径（web访问路径）
        //http://localhost:8080/community/user/header/xxx.png
//        利用当前线程获取用户
        User user = hostHolder.getUser();
        String headerUrl = domain + contextPath + "/user/header/" + filename;
        System.out.println(headerUrl);
        userService.updateHeader(user.getId(), headerUrl);
        return "redirect:/index";

    }

    // 向浏览器响应图片，向浏览器响应的不是网页也不是字符串，而是图片，是二进制的数据，通过流手动向浏览器输出，手动调用response往外写
    //http://localhost:8080/community/user/header/xxx.png 这里的路径不可以乱来，得是链接到文件名
    @RequestMapping(path = "/header/{fileName}", method = RequestMethod.GET)
    public void getHeader(@PathVariable("fileName") String fileName, HttpServletResponse response) {
//        服务器存放路径
        fileName = uploadPath + "/" + fileName;
//        文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
//        响应图片
        response.setContentType("image" + suffix);
//   读取文件得到输入流  新语法会关闭输入流
        try (FileInputStream fis = new FileInputStream(fileName)) {
//            response的输出流会自己关闭
            ServletOutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int b = 0;
            while ((b = fis.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }
        } catch (IOException e) {
            logger.error("读取头像失败" + e.getMessage());
        }
    }

    //    修改密码后怎么退出，后续需要思考
    @RequestMapping(path = "/changePwd", method = RequestMethod.POST)
    @LoginRequired
    public String changePwd(@CookieValue("ticket") String ticket, String oldPassword,
                            String newPassword, String confirmPwd, Model model) {
        User user = hostHolder.getUser();
        if (!user.getPassword().equals(CommunityUtil.md5(oldPassword) + user.getSalt())) {
            model.addAttribute("passwordMsg", "密码不正确，修改失败");
            return "site/setting";
        } else {

            if (newPassword == null) {
                model.addAttribute("newPasswordMsg", "新密码不能为空");
                return "site/setting";
            }
            if (!newPassword.equals(confirmPwd)) {
                model.addAttribute("confirmPasswordMsg", "两次密码输入不一致");
                return "site/setting";
            }
            userService.updatePassword(user.getId(), CommunityUtil.md5(newPassword) + user.getSalt());

        }
        userService.logout(ticket);
        return "redirect:/login";
    }

    //    个人主页
    @RequestMapping(path = "/profile/{userId}", method = RequestMethod.GET)
    public String getProfilePage(@PathVariable("userId") int userId, Model model) {
        User user = userService.findUserById(userId);
//        防止攻击
        if (user == null) {
            throw new RuntimeException("该用户不存在");
        }
//        用户
        model.addAttribute("user", user);
//        点赞数量
        int userLikeCount = likeService.findUserLikeCount(userId);
        model.addAttribute("userLikeCount", userLikeCount);
//        关注数量
        long followeeCount = followService.findFolloweeCount(userId, ENTITY_TYPE_USER);
        model.addAttribute("followeeCount", followeeCount);
//        粉丝数量
        long followerCount = followService.findFollowerCount(ENTITY_TYPE_USER, userId);
        model.addAttribute("followerCount", followerCount);
//        是否已关注
        boolean hasFollowed = false;
        if (hostHolder.getUser() != null) {
            hasFollowed = followService.hasFollowed(hostHolder.getUser().getId(),
                    ENTITY_TYPE_USER, userId);
        }
        model.addAttribute("hasFollowed", hasFollowed);
        return "site/profile";
    }
}
