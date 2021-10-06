package com.lzf.jdbc;

import java.sql.*;

public class testJdbc2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSI=true";
        String username = "root";
        String password = "root";

//        加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2.连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
//        3.编写sql
//        SQLSyntaxErrorException: sql语法错误
        String sql = "insert into users(id,name,password,email,birthday) values (?,?,?,?,?)";
//        4.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, 4);//按占位符赋值
        preparedStatement.setObject(2, "狂神");//按占位符赋值
        preparedStatement.setObject(3, "123456");//按占位符赋值
        preparedStatement.setObject(4, "ks@qq.com");//按占位符赋值
        preparedStatement.setObject(5, new Date(new java.util.Date().getTime()));//按占位符赋值
//        5.执行sql
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("插入成功");
        }
//        6.关闭连接 先开的后关
        preparedStatement.close();
        connection.close();

    }
}
