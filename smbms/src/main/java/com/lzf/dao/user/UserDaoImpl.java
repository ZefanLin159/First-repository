package com.lzf.dao.user;

import com.lzf.dao.BaseDao;
import com.lzf.pojo.Role;
import com.lzf.pojo.User;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //从数据库获得要登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from `smbms_user` where `userCode`=?";
            Object[] params = {userCode};
            rs = BaseDao.executeC(connection, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getDate("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getDate("modifyDate"));
            }
            BaseDao.closeResource(connection, null, rs);
        }

        return user;
    }

    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        int executeRUD = 0;
        if (connection != null) {
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object params[] = {password, id};
            executeRUD = BaseDao.executeRUD(connection, sql, params);
            BaseDao.closeResource(connection, null, null);
        }
        return executeRUD;
    }

    //重要重要
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();//存放我们的参数


            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }
            System.out.println("UserDaoImpl-->userName = " + userName);
            System.out.println("UserDaoImpl-->userRole = " + userRole);
            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
//            怎么把list转化为数组
            Object[] objects = list.toArray();
            System.out.println("UserDaoImp->getUserCount " + sql.toString());

            rs = BaseDao.executeC(connection, sql.toString(), objects);

            if (rs.next()) {
                count = rs.getInt("count");
            }
//            connection应该在业务层关闭，因为会处理业务
            BaseDao.closeResource(null, null, rs);
        }
        return count;
    }

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        ArrayList<User> usersList = new ArrayList<User>();
        int lineNo = 0;
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.* , r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();
            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }
//            创建日期倒序排序
            sql.append(" order by creationDate DESC limit ?,?");
//            分页算法(等会听一下）
/*            在数据库中，分页使用 limit startIndex，pageSize；总数
            当前页第一个记录的行号 （当前页-1）*页面大小
            0，5第一页
            5，5第二页
            10，5第三页
            */
            lineNo = (currentPageNo - 1) * pageSize;
            list.add(lineNo);
            list.add(pageSize);
            Object[] params = list.toArray();
//            System.out.println("sql-->" + sql.toString());
            ResultSet rs = BaseDao.executeC(connection, sql.toString(), params);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setUserRole(rs.getInt("userRole"));
                user.setUserRoleName(rs.getString("userRoleName"));
                usersList.add(user);
            }
            BaseDao.closeResource(null, null, rs);

        }
        return usersList;
    }


}
