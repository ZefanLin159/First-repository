package com.lzf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzf.domain.Book;

public interface IBookService extends IService<Book> {


    Boolean modify(Book book);

    public IPage<Book> getPage(int currentPage, int pageSize);
}
