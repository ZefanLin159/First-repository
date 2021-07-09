package com.lesson3;

import com.lesson2.utils.jdbcUtils;

import java.sql.*;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            //PreparedStatement 防止sql注入的本质，把传递进来的参数当作字符
            //假设其中存在转义字符，比如'会被直接转义掉
            String sql = " INSERT INTO users(id,`name`,`password`,email,birthday) VALUES (?,?,?,?,?)";//mybatis
//            String sql = "update users set `name` =?  where `id` = ?;
//            String sql = "delete from update where `id` =?"
            preparedStatement = connection.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值
            preparedStatement.setInt(1, 5);//1代表第一个问号
            preparedStatement.setString(2, "lin");
            preparedStatement.setString(3, "111");
            preparedStatement.setString(4, "222@qq.com");
            //注意点：sql.Date 数据库使用
            //注意点：util.Date java使用 获得时间戳
//          preparedStatement.setDate(5,new java.sql.Date(new Date().getTime());

            preparedStatement.setDate(5, Date.valueOf("1992-11-11"));

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.release(connection, preparedStatement, null);
        }
    }
}
