package com.lesson04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lesson2.utils.jdbcUtils;

public class TestTransaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            //关闭数据库的自动提交功能,自动会开启事务
            connection.setAutoCommit(false);//开启事务
            //
            String sql1 = "update `account` set money = money -100 where `name`  = 'A'";
            st = connection.prepareStatement(sql1);
            st.executeUpdate();
            String sql2 = "update `account` set money = money +100 where `name`  = 'B'";
            st = connection.prepareStatement(sql2);
            st.executeUpdate();
            //业务完毕，提交事务
            connection.commit();
            System.out.println("提交成功");

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, st, resultSet);
        }
    }
}
