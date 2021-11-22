package com.lzf.dao;

import com.lzf.pojo.User;
import com.lzf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public  void testLog4j(){
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug：进入了testLog4j");
        logger.error("error:进入testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> newMap = new HashMap<>();
        newMap.put("startIndex",1);
        newMap.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(newMap);
        for (User user : userByLimit) {
            System.out.println(user);
        }

    }
}
