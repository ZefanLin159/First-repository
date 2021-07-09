package com.lesson.example01;

import java.sql.*;

public class jdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode = true &characterEncoding = utf8 & usesSSL = true";
        String username = "root";
        String pwd = "root";
        //3.连接成功，数据库对象 Connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, pwd);

        //4.执行sql的对象 Statement 执行sql的对象
        Statement statement = connection.createStatement();

        //5.执行sql的对象去执行sql
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id = " + resultSet.getInt("id"));
            System.out.println("name = " + resultSet.getString("name"));
            System.out.println("pwd = " + resultSet.getString("password"));
            System.out.println("email = " + resultSet.getString("email"));
            System.out.println("birth = " + resultSet.getDate("birthday"));
            System.out.println("====================================================");
        }

//        Statement st = connection.createStatement();
//        String sql1 = "INSERT into `user`(`name`,`pwd`,`email`,`birth`) values(...)";
//        String sql2 = "delete from `user` where id = 1";
//        String sql3 = "update `user` set `name` = 'xx' where `name` = 'xx'";

//        int num = st.executeUpdate(sql1);
//        int num1 = st.executeUpdate(sql2);
//        int num3 = st.executeUpdate(sql3);
//        if (num > 0) {
//            System.out.println("xx成功");
//        }

        //6.释放连接 最晚开的最先关，避免造成资源浪费
        resultSet.close();
        statement.close();
        connection.close();
    }
}
