package com.lzf.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数: 统计Session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听：看你的一举一动
    //一旦创建session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
    }

    //销毁监听
    //一旦销毁session就会触发一次这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
