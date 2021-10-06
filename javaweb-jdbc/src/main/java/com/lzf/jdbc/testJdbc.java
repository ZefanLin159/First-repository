package com.lzf.jdbc;

import java.sql.*;

public class testJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSI=true";
        String username = "root";
        String password = "root";

//        加载驱动
        Class.forName("com.mysql.jdbc.Driver");
//        2.连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
//        3.向数据库发送sql的对象statement：crud
        Statement statement = connection.createStatement();
//        4.编写sql
        String sql = "select * from users";
//        5.执行sql,返回一个ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
//        增删改都使用这个
//        int i = statement.executeUpdate("delete from users where id = 4");
        while (resultSet.next()){
            System.out.println("id = "+resultSet.getObject("id"));
            System.out.println("name = "+resultSet.getObject("name"));
            System.out.println("password = "+resultSet.getObject("password"));
            System.out.println("email = "+resultSet.getObject("email"));
            System.out.println("birthday = "+resultSet.getObject("birthday"));
        }
//        6.关闭连接 先开的后关
        resultSet.close();
        statement.close();
        connection.close();

    }
}
