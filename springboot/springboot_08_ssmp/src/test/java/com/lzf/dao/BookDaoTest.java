package com.lzf.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzf.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
//        System.out.println(bookDao.selectById(1));
        bookDao.selectById(1);
    }

    @Test
    void testGetByAllBook() {
        List<Book> books = bookDao.selectList(null);
//        System.out.println(books);
    }


    @Test
    void InsertBook() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testGetPage() {
        IPage iPage = new Page(1, 5);
        bookDao.selectPage(iPage, null);
        System.out.println(iPage.getPages());
//        iPage.getCurrent();
//        iPage.getRecords();
    }

//    @Test
//    void testGetBy(){
////      代表  select * from tbl_book where name like %spring%
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name","spring");
//        bookDao.selectList(qw);
//    }

    @Test
    void testGetBy() {
        String name = "spring";
//      代表  select * from tbl_book where name like %spring%
//        lambda获取变量名
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        要加入判断条件，复习
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }

}
