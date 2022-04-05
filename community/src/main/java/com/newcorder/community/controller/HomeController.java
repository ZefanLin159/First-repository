package com.newcorder.community.controller;

import com.newcorder.community.dao.UserMapper;
import com.newcorder.community.entity.DiscussPost;
import com.newcorder.community.entity.Page;
import com.newcorder.community.entity.User;
import com.newcorder.community.service.DiscussPostService;
import com.newcorder.community.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
//        方法调用前，springMVC会自动实例化model和page，将Page注入Model
//        所以，在thymeleaf中可以直接访问Page对象中的数据 Model model, Page page
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());

        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "index";
    }

//    @RequestMapping(path = "/test")
//    public String testTest(Model model) {
//        model.addAttribute("testST", 123);
//        return "test";
//    }
}
