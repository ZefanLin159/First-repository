package com.lzf.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
//        proxy.add();
        proxy.query();
    }
//    1.改动原有的业务代码，在公司中是大忌
}
