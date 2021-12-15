import com.lzf.dao.UserMapper;
import com.lzf.pojo.User;
import com.lzf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
//        mapper.updateUser(new User(2,"aaaa","bbbb"));
        sqlSession.clearCache();//手动清理缓存
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        sqlSession.close();
    }
}
