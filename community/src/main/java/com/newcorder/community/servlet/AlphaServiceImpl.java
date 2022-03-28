package com.newcorder.community.servlet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class AlphaServiceImpl implements AlphaService {
    public AlphaServiceImpl(){
        System.out.println("实例化AlphaServiceImpl");
    }
    @PostConstruct
    @Override
    public void init() {
        System.out.println("初始化AlphaServiceImpl");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaServiceImpl");
    }
}
