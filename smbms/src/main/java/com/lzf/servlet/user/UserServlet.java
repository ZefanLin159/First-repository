package com.lzf.servlet.user;

import com.lzf.pojo.Role;
import com.lzf.pojo.User;
import com.lzf.service.role.RoleServiceImpl;
import com.lzf.service.user.UserServiceImp;
import com.lzf.utils.Constants;
import com.lzf.utils.PageSupport;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//实现servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("savepwd")) {
            this.updatePwd(req, resp);
        } else if (method != null && method.equals("query")) {
            this.query(req, resp);
        }
    }

    //    重点难点
    private void query(HttpServletRequest req, HttpServletResponse resp) {
//        查询用户列表
        int queryUserRole = 0;
        String queryName = req.getParameter("queryname");   //用户名
        String temp = req.getParameter("queryUserRole");  //下拉框
        System.out.println(queryName);
        String pageIndex = req.getParameter("pageIndex");

//        获取用户列表
        UserServiceImp userServiceImp = new UserServiceImp();

//        第一次走这个请求，一定是第一页，页面大小是固定的；
        int pageSize = Constants.PAGE_SIZE;
        int currentPageNo = 1;
        userServiceImp.getUserList(queryName, queryUserRole, currentPageNo, pageSize);
        if (queryName == null) {
            queryName = "";
        }
        if (temp != null && !temp.equals("")) {
            queryUserRole = Integer.parseInt(temp); //给查询赋值！ 0，1，2，3
            System.out.println("UserServlet-->userRole = "+queryUserRole);
        }
        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

//        获取用户的总数(分页：上一页，下一页）
        System.out.println("UserServlet-->temp ="+temp);
        int userCount = userServiceImp.getUserCount(queryName, queryUserRole);
//        总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(userCount);

        int totalPageCount = pageSupport.getTotalPageCount();
//        控制首页和尾页(避免出现error 500 异常）
        int totalCount = pageSupport.getTotalCount();
        if (totalCount < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalCount) {
            currentPageNo = totalCount;
        }
//        获取用户列表展示
        List<User> userList = userServiceImp.getUserList(queryName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList", userList);

//        获取角色列表展示
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("queryUserName", queryName);
        req.setAttribute("queryUserRole", queryUserRole);
        req.setAttribute("totalPageCount", totalPageCount);

//        返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        //       从session里面拿id
        boolean flag = false;
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String newPassword = req.getParameter("newpassword");
        if (attribute != null && !StringUtils.isNullOrEmpty(newPassword)) {
            UserServiceImp userServiceImp = new UserServiceImp();
            flag = userServiceImp.updatePwd(((User) attribute).getId(), newPassword);
            if (flag) {
                req.setAttribute("message", "修改密码成功，请退出使用新密码登录");
//                密码修改成功，移除当前session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        } else {
            req.setAttribute("message", "新密码有问题");
            System.out.println(attribute.toString());
            System.out.println(StringUtils.isNullOrEmpty(newPassword));
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
