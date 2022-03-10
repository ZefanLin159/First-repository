package com.lzf.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EncodingController {
//    过滤器解决乱码
    @RequestMapping(value = "/e/e1")
    public String test(String name, Model model) {
        model.addAttribute("msg", name);

        return "test";
    }
}
