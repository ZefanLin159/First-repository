package com.newcorder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*这个自定义的注解是为了表示一些网页是否可以在非登录状态下访问*/
@Target(ElementType.METHOD)
//程序运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}
