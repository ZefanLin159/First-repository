package com.lesson05.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils_DBCP {
    private static DataSource dataSource = null;
    static {
        try {
            InputStream in = jdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");//注意文件名啊我ri
            Properties properties = new Properties();
            properties.load(in);
            //创建数据源 工厂模式 --> 创建
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
           // throw new ExceptionInInitializerError("DBCP初始化异常，请检查配置文件！！！");
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();//从数据源中获取连接
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
