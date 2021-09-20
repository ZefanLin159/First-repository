package com.lzf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookiesDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        服务器告诉你来的时间，把这个时间封装成为一个新建，下次再来就知道你来了

//        解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
//      cookie，服务端从客户端获取
        Cookie[] cookies = req.getCookies();//这里返回数组，说明cooke可能存在多个
//        判断cookie是否存在
        if (cookies != null) {
//            如果存在cookie，怎么办
            out.write("你上一次访问的时间是");
//            for (Cookie cookie:cookies) {
//
//            }
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
//                获取cookie的名字
                if (cookie.getName().equals("lastLoginTime")) {
//                 获取cookie中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());//时间戳
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }
        //服务器给客户端响应一个cookie；
        Cookie newCookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
//        设置cookie有效期
        newCookie.setMaxAge(24*60*60); //设置有效期为一天，似乎可以设置为0
        resp.addCookie(newCookie);//设置完添加入响应


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
