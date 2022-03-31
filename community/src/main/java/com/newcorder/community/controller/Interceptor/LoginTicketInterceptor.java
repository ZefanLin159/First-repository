package com.newcorder.community.controller.Interceptor;

import com.newcorder.community.entity.LoginTicket;
import com.newcorder.community.entity.User;
import com.newcorder.community.service.UserService;
import com.newcorder.community.util.CookieUtil;
import com.newcorder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginTicketInterceptor implements HandlerInterceptor {
    private final UserService userService;

    private final HostHolder hostHolder;

    public LoginTicketInterceptor(UserService userService, HostHolder hostHolder) {
        this.userService = userService;
        this.hostHolder = hostHolder;
    }

    //controller前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        从cookie中获取凭证
        String ticket = CookieUtil.getValue(request, "ticket");
        if (ticket != null) {
//            查询凭证
            LoginTicket loginTicket = userService.findLoginTicket(ticket);
//            检查凭证是否有效(搜索到对应的登录凭证，以及是否激活，是否过期）
            if (loginTicket != null && loginTicket.getStatus() == 0 && loginTicket.getExpired().after(new Date())) {
//                根据凭证查询用户
                User user = userService.findById(loginTicket.getUserId());
//                在本次请求中持有用户（多线程的情况，很多个浏览器对应一个服务器），存用户
                hostHolder.setUser(user); //线程启动的时候一直存在

            }
        }
        return true;
    }

    //controller后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = hostHolder.getUser();
        if (user != null && modelAndView != null) {
            modelAndView.addObject("loginUser", user);
        }

    }

    //流程结束
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
