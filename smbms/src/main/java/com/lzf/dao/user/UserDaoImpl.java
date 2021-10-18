package com.lzf.dao.user;

import com.lzf.dao.BaseDao;
import com.lzf.pojo.User;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
