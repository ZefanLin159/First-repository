//package com.newcorder.community.config;
//
//import com.newcorder.community.util.CommunityConstant;
//import com.newcorder.community.util.CommunityUtil;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter implements CommunityConstant {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        授权
//        http.authorizeRequests()
//                .antMatchers(
////                        拦截登陆之后才能使用的权限
//                        "/user/setting",
//                        "/user/upload",
//                        "/discuss/add",
//                        "/comment/add/**",
//                        "/letter/**",
//                        "/notice/**",
//                        "/like",
//                        "/follow",
//                        "/unfollow"
//                )
//                .hasAnyAuthority(
//                        AUTHORITY_USER, AUTHORITY_MODERATOR, AUTHORITY_ADMIN
//                )
//                .anyRequest().permitAll()
//                .and().csrf().disable();
////        权限不够时的处理
//        http.exceptionHandling()
////                没有登录的处理
//                .authenticationEntryPoint((request, response, authException) -> {
//                    String xRequestedWith = request.getHeader("x-requested-with");
//                    if ("XMLHttpRequest".equals(xRequestedWith)) {
//                        response.setContentType("application/plain;charset=utf8");
//                        PrintWriter writer = response.getWriter();
//                        writer.write(CommunityUtil.getJSONString(403, "你还没有登录!"));
//                    } else {
//                        response.sendRedirect(request.getContextPath() + "/login");
//                    }
//                })
//                .accessDeniedHandler(
////                        权限不足的处理
//                        (request, response, accessDeniedException) -> {
//                            String xRequestedWith = request.getHeader("x-requested-with");
//                            if ("XMLHttpRequest".equals(xRequestedWith)) {
//                                response.setContentType("application/plain;charset=utf-8");
//                                PrintWriter writer = response.getWriter();
//                                writer.write(CommunityUtil.getJSONString(403, "你没有访问此功能的权限"));
//                            } else {
//                                response.sendRedirect(request.getContextPath() + "/denied");
//                            }
//
//                        }
//                );
////        security 底层默认会拦截/logout请求，进行退出处理
////        覆盖它默认的逻辑，才能执行我们自己的退出代码(制造一个虚假的链接欺骗security
//        http.logout().logoutUrl("/securitylogout");
//
//
//    }
//}
