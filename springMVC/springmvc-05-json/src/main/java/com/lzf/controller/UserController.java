package com.lzf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class UserController {
    @RequestMapping("/j1")
//    在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
    @ResponseBody
    public String json1() throws JsonProcessingException {
//        jackson,objectmapper
        ObjectMapper objectMapper = new ObjectMapper();
//        创建一个对象
        User user = new User("lzf", 23, "male");
        String str = objectMapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        User user1= new User("lzf1", 23, "male");
        User user2= new User("lzf1", 23, "male");
        User user3= new User("lzf1", 23, "male");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        String string = objectMapper.writeValueAsString(users);
        return string;
    }
    
}
