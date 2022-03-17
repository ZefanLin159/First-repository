package com.lzf;

import com.lzf.dao.BookDao;
import com.lzf.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot07DruidApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        List<Book> byAllBook = bookDao.getByAllBook();
        System.out.println(byAllBook);
    }

}
