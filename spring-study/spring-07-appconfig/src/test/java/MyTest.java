import com.lzf.config.LinConfig;
import com.lzf.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//        配置类方式去做，我们只能通过这种方式来获取容器，通过配置类的class对象加载
       ApplicationContext context = new AnnotationConfigApplicationContext(LinConfig.class);
        User user = context.getBean("getUser",User.class);
        System.out.println(user.getName());
    }
}
