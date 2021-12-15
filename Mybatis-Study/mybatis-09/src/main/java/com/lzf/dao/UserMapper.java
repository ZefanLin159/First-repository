package com.lzf.dao;

import com.lzf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
//    List<User> queryUserById();
//    根据id查询用户
    User queryUserById(@Param("id")int id);

    int updateUser(User user);
}
