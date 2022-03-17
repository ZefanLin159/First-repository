package com.lzf.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzf.dao.BookDao;
import com.lzf.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
