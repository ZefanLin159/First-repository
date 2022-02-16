package com.lzf.mapper;

import com.lzf.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    //    我们所有操作都是用sqlSession来执行，在原来，现在都使用sqlSessionTemplate(万物皆注入，要给一个set方法）
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

//    暂且理解为加了一层？
    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
