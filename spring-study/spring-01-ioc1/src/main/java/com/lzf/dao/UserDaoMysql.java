package com.lzf.dao;

public class UserDaoMysql implements UserDao{
    @Override
    public void getUser() {

        System.out.println("mysql获取用户数据");
    }
}
