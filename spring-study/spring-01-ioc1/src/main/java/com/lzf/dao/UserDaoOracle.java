package com.lzf.dao;

public class UserDaoOracle implements UserDao{

    @Override
    public void getUser() {
        System.out.println("oracle获取用户数据");
    }
}
