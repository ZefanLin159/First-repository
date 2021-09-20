package com.lzf.servlet;

import com.lzf.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //解决乱码问题
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset = utf-8");
//        得到Session
        HttpSession session = req.getSession();
//        给session存放东西
        session.setAttribute("name",new Person("夏琳",24));
        //获取session的id
        String id = session.getId();
        //判断session是否新创建
        if(session.isNew()){
            resp.getWriter().write("session创建成功，id"+id);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，id"+id);
        }
//        //Session创建的时候做了什么事情
//        Cookie cookie = new Cookie("JSESSIONID", id);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
