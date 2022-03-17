package com.lzf;

import com.lzf.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@SpringBootTest(classes = ...)
class Springboot04JunitApplicationTests {
//    1.注入要测试的对象
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println("test");
        bookDao.save();
    }

}
