package com.lzf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {
//    @RequestMapping("/m1/h1")
//    public String test(HttpServletResponse response, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        System.out.println(session.getId());
//
//        return "test";
//    }
    @RequestMapping("/m1/h2")
    public String test2(Model model){
        model.addAttribute("msg","ModelTest1");
        return "test";
    }
}
