package com.newcorder.community.config;

import com.newcorder.community.controller.Interceptor.AlphaInterceptor;
import com.newcorder.community.controller.Interceptor.DataInterceptor;
import com.newcorder.community.controller.Interceptor.LoginRequiredInterceptor;
import com.newcorder.community.controller.Interceptor.LoginTicketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AlphaInterceptor alphaInterceptor;
    private final LoginTicketInterceptor loginTicketInterceptor;
    @Autowired
    private DataInterceptor dataInterceptor;
//    抛弃拦截器
//    @Autowired
//    private  LoginRequiredInterceptor loginRequiredInterceptor;


    public WebMvcConfig(LoginTicketInterceptor loginTicketInterceptor, AlphaInterceptor alphaInterceptor) {
        this.loginTicketInterceptor = loginTicketInterceptor;
        this.alphaInterceptor = alphaInterceptor;
    }

    //    拦截有先后顺序
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//      logging的输出级别没有打开，改为debug，已订正
        registry.addInterceptor(alphaInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg")
                .addPathPatterns("/login");

// addInterceptor方法是注册一个生命周期拦截器，addPathPatterns方法是拦截的url地址，
        // excludePathPatterns是排除那些地址不拦截，order方法是拦截顺序，就是拦截器执行链的执行顺序，值越大，拦截就越靠后,这里注册两个是为了验证顺序的
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg");

//        拦截一些没登录前不能访问的网页
//        registry.addInterceptor(loginRequiredInterceptor)
//                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg");

        registry.addInterceptor(dataInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg");

    }


}
