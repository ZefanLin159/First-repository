package com.lzf.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }

    //        获取数据库的链接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return connection;
    }

    //编写查询公共类
    public static ResultSet executeC(Connection connection, String sql, Object[] params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
//            setObject，占位符从1开始，但是我们的数组是从0开始
            preparedStatement.setObject(i + 1, params[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        return resultSet;
    }

    //    编写增删改公共方法
    public static int executeRUD(Connection connection, String sql, Object[] params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
//            setObject，占位符从1开始，但是我们的数组是从0开始
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();

    }

    //    关闭数据库链接
    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        if (resultSet != null) {
            try {
                resultSet.close();
                //gc回收
                resultSet = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();

            }
        }


        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                //gc回收
                preparedStatement = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();

            }
        }

        if (connection != null) {
            try {
                connection.close();
                //gc回收
                connection = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();

            }
        }
        return flag;
    }

}
