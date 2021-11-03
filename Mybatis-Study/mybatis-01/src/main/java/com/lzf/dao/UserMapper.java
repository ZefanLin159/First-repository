package com.lzf.dao;

import com.lzf.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

//    插入一个用户
    int addUser(User user);
//    万能的map(适合多参数传递）
    int addUser2(Map<String,Object> map);
//     修改用户
    void updateUser(User user);
//    删除用户
    void deleteUser(int id);

    List<User> getUserLike(String value);

}
