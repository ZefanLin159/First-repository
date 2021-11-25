import com.lzf.dao.TeacherMapper;
import com.lzf.pojo.Teacher;
import com.lzf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
//    @Test
//    public void testGetTeacher(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        List<Teacher> teacherList = mapper.getTeacher();
////        输出结果，老师为空
//        for (Teacher teacher : teacherList) {
//            System.out.println(teacher);
//        }
//        sqlSession.close();
//    }

    @Test
    public void TestGetTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

}
