package com.lzf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//如果想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配
//扩展springmvc  dispatchServlet
@Configuration
public class MymvcConfig implements WebMvcConfigurer {
    //     实现了 ViewResolver 视图解析器的类，我们就可以看作视图解析器
    public static class MyViewResolver implements ViewResolver {
        @Bean
        public ViewResolver myViewResolver() {
            return new MyViewResolver();
        }

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
