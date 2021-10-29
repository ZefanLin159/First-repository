package com.lzf.service.user;

import com.lzf.dao.BaseDao;
import com.lzf.dao.user.UserDao;
import com.lzf.dao.user.UserDaoImpl;
import com.lzf.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserServiceImp implements UserService {
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
        BaseDao.closeResource(connection, null, null);
        return loginUser;
    }

    public boolean updatePwd(int id, String password) {
        boolean flag = false;
        Connection connection = null;
        connection = BaseDao.getConnection();
//        修改密码
        try {
            if (userDao.updatePwd(connection, id, password) > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public int getUserCount(String username, int userRole) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            System.out.println("UserServiceImp-->userRole = "+userRole);
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;

    }

    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;
//        System.out.println("queryUserName --> " + queryUserName);
//        System.out.println("queryUserRole --> " + queryUserRole);
//        System.out.println("currentPageNo --> " + currentPageNo);
//        System.out.println("pageSize --> " + pageSize);

        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

//    @Test
//    public void test() {
//        UserServiceImp userServiceImp = new UserServiceImp();
//        User admin = userServiceImp.login("admin", "1234567321");
//        System.out.println(admin.getUserPassword());
//    }
//
//    @Test
//    public void test2(){
//        UserServiceImp userServiceImp = new UserServiceImp();
//        int userCount = userServiceImp.getUserCount(null, 0);//输出所有管理员的数量
//        System.out.println("userCount = "+ userCount);
//    }

//    @Test
//    public void test3() {
//        UserServiceImp userServiceImp = new UserServiceImp();
//        List<User> userList = userServiceImp.getUserList(null, 0, 1, 4);
////        for (int i = 0; i < userList.size(); i++) System.out.println(Arrays.toString(new List[]{userList}));
//        int i = 0;
//    }
}
