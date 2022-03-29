package com.newcorder.community.service;

import com.newcorder.community.dao.UserMapper;
import com.newcorder.community.entity.User;
import com.newcorder.community.util.CommunityUtil;
import com.newcorder.community.util.MailClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${community.path.domain}")
    private String domain;

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
        userMapper.insertUser(user);

//        激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail()); //不是太理解？？？
        // url :http://localhost:8080/community/activation/(用户id)/(激活码）
        String url = domain + contextPath + "/activation" + user.getId() + user.getActivationCode();
        context.setVariable("url", url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号", content);


        return map;
    }

    public User findById(int id) {
        return userMapper.selectById(id);
    }

    public User findByName(String username) {
        return userMapper.selectByName(username);
    }

    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateStatus(int id, int status) {
        return userMapper.updateStatus(id, status);
    }

    public int updateHeader(int id, String headerUrl) {
        return userMapper.updateHeader(id, headerUrl);
    }

    public int updatePassword(int id, String password) {
        return userMapper.updatePassword(id, password);
    }
}
