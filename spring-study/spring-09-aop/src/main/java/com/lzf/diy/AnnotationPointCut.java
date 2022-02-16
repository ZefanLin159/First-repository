package com.lzf.diy;

//方式三：使用注解方式实现aop

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//标注这个类为一个切面
@Aspect
public class AnnotationPointCut {
    //1.execution():表达式主体
    //2.第一个 * 号,表示返回类型，* 号表示所有的类型
    //3.包路径
    //4.第二个 * 号, 表示类名，* 号表示所有的类
    //5.*(..): * 号表示方法名， 括号内为方法的参数, 两个点表示任何参数
    @Before("execution(* com.lzf.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前==========");

    }

    @After(("execution(* com.lzf.service.UserServiceImpl.*(..))"))
    public void after(){
        System.out.println("方法执行后=========");
    }

//    在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around(("execution(* com.lzf.service.UserServiceImpl.*(..))"))
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前============");
//        执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后===========");
//        System.out.println(proceed);
    }

}
