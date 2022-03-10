package com.lzf.controller;

import com.lzf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    //localhost:8080/user/u1?name=xxx;
    @GetMapping("/u1")
    public String test1(@RequestParam("username") String name, Model model) {
//        1.接收前端参数
        System.out.println("接收到前端的参数"+name);
//        2.将返回的结果传递给前端
        model.addAttribute("msg",name);
//        3.视图跳转
        return "test";
    }
//    前端接收的是一个对象：id，name，age
    @GetMapping("/u2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }
}
