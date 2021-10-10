package com.lzf.service;

import com.lzf.dao.BaseDao;
import com.lzf.dao.user.UserDao;
import com.lzf.dao.user.UserDaoImpl;
import com.lzf.pojo.User;
import org.junit.Test;

import java.sql.Connection;

public class UserServiceImp implements UserService{
//    业务层都会调用dao层，所以我们要引入dao层；
    private UserDao userDao;
    public UserServiceImp() {
        this.userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        connection = BaseDao.getConnection();
//        通过业务层调用对应的具体的数据库操作
        User loginUser = userDao.getLoginUser(connection, userCode);
        BaseDao.closeResource(connection,null,null);
        return loginUser;
    }

    @Test
    public void test(){
        UserServiceImp userServiceImp = new UserServiceImp();
        User admin = userServiceImp.login("admin", "1234567321");
        System.out.println(admin.getUserPassword());
    }

}
