import com.lzf.dao.UserMapper;
import com.lzf.pojo.User;
import com.lzf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testNotation() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> user = mapper.getUser();
//        for (User user1 : user) {
//            System.out.println(user1);
//        }
        User userById = mapper.getUserById(2);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void notationAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(6, "lzg", "45566"));
//        System.out.println();
        sqlSession.close();
    }
    @Test
    public void notationUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"cbx","520520"));
        sqlSession.close();
    }

    @Test
    public void notationDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);
        sqlSession.close();
    }
}
