package com.lzf.dao;

import com.lzf.pojo.User;
import com.lzf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;



public class UserDaoTest {
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

}
