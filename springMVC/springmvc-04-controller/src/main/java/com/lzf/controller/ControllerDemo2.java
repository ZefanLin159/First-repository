package com.lzf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerDemo2 {
    @RequestMapping("/t2")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerDemo2");
        return "test";
    }
}
