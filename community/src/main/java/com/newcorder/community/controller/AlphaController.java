package com.newcorder.community.controller;

import com.newcorder.community.util.CommunityUtil;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody // 界面响应输出该字符串 "Hello spring boot"
    public String sayHello() {
        return "Hello spring boot";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
//        获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + ": " + header);
        }
        System.out.println(request.getParameter("code")); //可以在前端传值
//        返回相应数据
        response.setContentType("text/html;charset = utf-8");
        try (
                PrintWriter writer = response.getWriter()) {
            writer.write("<h1>牛客网<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students")
    @ResponseBody
    public String students(@RequestParam(required = false, name = "current", defaultValue = "1") int current,
                           @RequestParam(required = false, name = "limit", defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    //Restful风格
    @RequestMapping("/student/{id}")
    @ResponseBody
    public String student(@PathVariable(name = "id") int id) {
        System.out.println(id);
        return "a student";
    }

    //POST 请求（一般需要表单）
    @RequestMapping(method = RequestMethod.POST, path = "/student")
    @ResponseBody
    public String saveStudent(String name, int age) { //可以用RequestParam注解，或者名字对应即可
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //相应html数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张三");
        modelAndView.addObject("age", 30);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {//dispatcherServlet持有model的引用，Model是个对象
        model.addAttribute("name", "哈啰工业大学");
        model.addAttribute("age", 70);
        return "/demo/view";
    }

    //    相应json数据（异步请求）
//    java对象-->JSON字符串-->JS对象语言
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmp() {
        List<Map<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("salary", 8000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "李四");
        map.put("age", 25);
        map.put("salary", 2000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "王五");
        map.put("age", 21);
        map.put("salary", 23200.00);
        list.add(map);
        return list;

    }

    //    cookie
    @RequestMapping(path = "cookie/set", method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
//        cookie只能存字符串
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
//        设置cookie生效的范围
        cookie.setPath("/community/alpha");
//        设置cookie的生存时间（单位：second)
        cookie.setMaxAge(60 * 10);
//        发送cookie
        response.addCookie(cookie);

        return "set cookie";
    }


    //    cookie
    @RequestMapping(path = "cookie/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code) {
        System.out.println(code);
        return "get cookie";
    }

    //    session
    @RequestMapping(path = "session/set", method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session) {
        session.setAttribute("id", 1);
        session.setAttribute("name", "Test");
        return "set session";
    }

    @RequestMapping(path = "session/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session) {
        System.out.println(session.getId());
        Integer testId = (Integer) session.getAttribute("id");
        String testS = (String) session.getAttribute("name");
        System.out.println(testId);
        System.out.println(testS);

        return "get session";
    }
}
