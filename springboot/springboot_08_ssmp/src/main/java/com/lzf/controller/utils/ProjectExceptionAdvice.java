package com.lzf.controller.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //    拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
//        记录日志

//        通知运维

//        通知开发
        e.printStackTrace();
        return new R("服务器故障，请稍后再试");
    }

}
