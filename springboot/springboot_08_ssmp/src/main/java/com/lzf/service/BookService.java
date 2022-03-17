package com.lzf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzf.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAllBook();

    IPage<Book> getPage(int currentPage, int pageSize);
}
