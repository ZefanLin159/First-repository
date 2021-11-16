package com.lzf.dao;

import com.lzf.pojo.User;
import com.lzf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
//        获得sqlSession对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        执行sql
            List<User> userList = mapper.getUserList();
            System.out.println(Arrays.toString(userList.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        增删改查需要提交事务
        int res = mapper.addUser(new User(4, "haha", "12345"));
        if(res>0){
            System.out.println("插入成功");
        }
//        提交事务
        sqlSession.commit();
        for (User user : mapper.getUserList()) {
            System.out.println(user);
        }
        sqlSession.close();

    }




    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"hehe","123"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

}
