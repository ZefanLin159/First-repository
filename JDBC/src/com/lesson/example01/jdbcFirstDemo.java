package com.lesson.example01;

import java.sql.*;

public class jdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver"); //固定写法,新的数据库驱动是cj.jdbc.Driver
        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode = true&characterEncoding = utf8&usesSSL = true";
        String username = "root";
        String password = "root";

        //3.连接成功，数据库对象 Connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.执行sql的对象 Statement 执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql的对象去执行sql
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);//返回结果集，结果集中封装了我们全部的查询出来的结果

        while ((resultSet.next())){
            System.out.println("id = "+ resultSet.getObject("id"));
            System.out.println("name = "+ resultSet.getObject("name"));
            System.out.println("pwd = "+ resultSet.getObject("password"));
            System.out.println("email = "+ resultSet.getObject("email"));
            System.out.println("birth = "+ resultSet.getObject("birthday"));
            System.out.println("====================================================");
        }

        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
