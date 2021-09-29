package com.lzf.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //    初始化 web服务器启动就已经初始化了 随时等待监听对象出现
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");

    }

    //    链Chain：
//    1.过滤中的所有代码，在过滤特定请求的时候都会执行
//    必须要让过滤器继续同行 filterChain.doFilter(servletRequest,servletResponse);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset = utf-8");

        System.out.println("CharacterizeEncodingFilter执行前...");
        //让我们的请求继续走，如果不写，程序到这就停止了
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("CharacterizeEncodingFilter执行后...");
    }

    //销毁 关闭的时候销毁
    public void destroy() {
        System.out.println("销毁");

    }
}
