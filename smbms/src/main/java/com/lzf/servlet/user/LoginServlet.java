package com.lzf.servlet.user;

import com.lzf.pojo.User;
import com.lzf.service.UserService;
import com.lzf.service.UserServiceImp;
import com.lzf.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
//    Servlet:控制层，调用业务层

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start....");
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
//        和数据库中的密码进行对比，调用业务层
        UserServiceImp userServiceImp = new UserServiceImp();
        User isUser = userServiceImp.login(userCode, userPassword);//这里已经把登录的人查询出来了
        if(isUser != null){//查有此人，可以登录
            //将用户的信息放到session中
            req.getSession().setAttribute(Constants.USER_SESSION,isUser);
            //跳转到内部主页，重定向
            resp.sendRedirect("jsp/frame.jsp");
            System.out.println("登陆成功");
        }else {//若查无此人
            //转发回登录界面，顺带提示它，用户名或者密码错误
            req.setAttribute("error","用户名或者密码不正确");
            //作用，有点忘记了，查一查，请求转发
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            System.out.println("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
