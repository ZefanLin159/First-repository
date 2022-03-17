package com.lzf;

import com.lzf.dao.BookDao;
import com.lzf.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
//        System.out.println(bookDao.getById(1));
        List<Book> byAllBook = bookDao.getByAllBook();
        System.out.println(byAllBook);
    }

}
