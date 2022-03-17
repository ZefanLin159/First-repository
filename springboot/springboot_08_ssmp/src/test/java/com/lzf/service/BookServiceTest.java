package com.lzf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzf.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//记住加入这个测试组件，否则启动不了
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService ibookService;

    @Test
    void testById() {
        System.out.println(ibookService.getById(1));
    }

    @Test
    void testGetPage() {
//        IPage<Book> page = ibookService.getPage(2, 5);
//        System.out.println(page.getPages());
//        System.out.println(page.getCurrent());
//        System.out.println(page.getRecords());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
    }

    @Test
    void MPServiceTest() {
        Book book = new Book(13, "test", "test", "test");
        ibookService.updateById(book);
        ibookService.removeById(1);
        ibookService.list();
        IPage<Book> bookIpage = new Page<Book>(2, 5);
        ibookService.page(bookIpage, null);
        System.out.println(bookIpage.getTotal());
    }
}
