package com.lesson05;

import com.lesson05.utils.jdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testDBCP {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils_DBCP.getConnection();
            String sql = "select * from users where `id` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils_DBCP.release(connection, preparedStatement, null);
        }
    }
}
