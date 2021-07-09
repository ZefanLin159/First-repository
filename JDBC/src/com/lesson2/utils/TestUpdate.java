package com.lesson2.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection(); //获取数据库连接
            statement = connection.createStatement();//获得sql的执行对象
            String sql = "update `users` set `name` = 'beautiful' where `id` = 2";
            int i = statement.executeUpdate(sql);
            String sql1 = "select * from `users`" ;
            statement.executeQuery(sql1);
            if(i > 0){
                System.out.println("修改成功");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.release(connection,statement, null);
        }
    }
}
