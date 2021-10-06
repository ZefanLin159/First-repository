package com.lzf.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testJdbc3 {
    @Test
    public void test() throws  SQLException {  //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSI=true";
        String username = "root";
        String password = "root";
        Connection connection = null;
        try {

//        加载驱动
        Class.forName("com.mysql.jdbc.Driver");
//        2.连接数据库,代表数据库
         connection = DriverManager.getConnection(url, username, password);
//        3.通知数据库开启事务，false开启
        connection.setAutoCommit(false);
//        4.执行sql语句
        String sql = "update account set money = money - 100 where name = 'A'";
        connection.prepareStatement(sql).executeUpdate();
//        制造错误
//        int i = 1/0;

        String sql2 = "update account set money = money + 100 where name = 'B'";
        connection.prepareStatement(sql2).executeUpdate();
        connection.commit();
        System.out.println("success");
        }catch (ClassNotFoundException e){
            try {
                connection.rollback();//这里似乎有点问题
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}
