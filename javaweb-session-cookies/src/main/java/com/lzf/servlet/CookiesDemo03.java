package com.lzf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import static java.lang.System.out;

//中文设置传递
public class CookiesDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //      cookie，服务端从客户端获取
        Cookie[] reqCookies = req.getCookies();//这里取出请求中的数组，说明cooke可能存在多个
        PrintWriter out = resp.getWriter();
//        判断cookie是否存在
        if (reqCookies != null) {
//            如果存在cookie，怎么办
            out.write("你上一次访问的时间是");
//            for (Cookie cookie:cookies) {
//
//            }
            for (int i = 0; i < reqCookies.length; i++) {
                Cookie cookie = reqCookies[i];
//                获取cookie的名字
                if (cookie.getName().equals("name")) {
//                    out.println(cookie.getValue());
                    //解决乱码的一种方式
                    URLDecoder.decode(cookie.getValue(),"utf-8")
                    out.write(cookie.getValue());
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }
        // 编码
        Cookie cookie = new Cookie("name", URLEncoder.encode("小林","utf-8"));
        resp.addCookie(cookie);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
