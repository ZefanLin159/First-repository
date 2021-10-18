package com.lzf.service;

import com.lzf.dao.BaseDao;
import com.lzf.dao.user.UserDao;
import com.lzf.dao.user.UserDaoImpl;
import com.lzf.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

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
        User loginUser = null;
        try {
            loginUser = userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.closeResource(connection,null,null);
        return loginUser;
    }

    public boolean updatePwd(int id, String password) {
        boolean flag = false;
        Connection connection = null;
        connection = BaseDao.getConnection();
//        修改密码
        try {
            if(userDao.updatePwd(connection,id,password)>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    @Test
    public void test(){
        UserServiceImp userServiceImp = new UserServiceImp();
        User admin = userServiceImp.login("admin", "1234567321");
        System.out.println(admin.getUserPassword());
    }

}
