package com.lzf.servlet.user;

import com.lzf.pojo.User;
import com.lzf.service.UserService;
import com.lzf.service.UserServiceImp;
import com.lzf.utils.Constants;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//实现servlet
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //       从session里面拿id
        boolean flag = false;
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String newPassword = req.getParameter("newpassword");
        if(attribute != null && !StringUtils.isNullOrEmpty(newPassword)){
            UserServiceImp userServiceImp = new UserServiceImp();
            flag  = userServiceImp.updatePwd(((User) attribute).getId(), newPassword);
            if (flag) {
                req.setAttribute("message","修改密码成功，请退出使用新密码登录");
//                密码修改成功，移除当前session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                req.setAttribute("message","密码修改失败");
            }
        }else {
            req.setAttribute("message","新密码有问题");
            System.out.println(attribute.toString());
            System.out.println(StringUtils.isNullOrEmpty(newPassword));
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }
}
