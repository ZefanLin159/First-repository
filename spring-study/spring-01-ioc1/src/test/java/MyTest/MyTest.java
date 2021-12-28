package MyTest;

import com.lzf.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MyTest {
    public static void main(String[] args) {
////        用户实际调用的是业务层，dao层不需要接触
//        UserServiceImpl userService = new UserServiceImpl();
//       userService.getUser();

//        获取ApplicationContext，拿到spring的容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
//        容器在手，天下我有
        UserServiceImpl userServiceImp = (UserServiceImpl) context.getBean("userServiceImp");
        userServiceImp.getUser();


    }
}
