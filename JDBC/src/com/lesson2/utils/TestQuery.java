package com.lesson2.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from `users`";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){//返回结果集
                System.out.println("id = "+resultSet.getInt("id"));
                System.out.println("name = "+ resultSet.getString("name"));
                System.out.println("password = "+resultSet.getString("password"));
                System.out.println("email"+resultSet.getString("email"));
                System.out.println("birthday"+resultSet.getDate("birthday"));
                System.out.println("=================================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection,statement,resultSet);
        }
    }

}
