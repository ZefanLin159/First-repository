package com.lzf.service;

import com.lzf.pojo.User;

public interface UserService {
//    用户登录
    public User login(String userCode, String password);
}
