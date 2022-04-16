package com.newcorder.community;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@ComponentScan(basePackages ={"org.springframework.mail.javamail" })
public class CommunityApplication {

    @PostConstruct
    public void init() {
//        解决netty启动冲突的问题
        //Netty4Utils.setAvailableProcessors()
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
//        SpringApplication.run(Application.class, "--debug");
    }

}
