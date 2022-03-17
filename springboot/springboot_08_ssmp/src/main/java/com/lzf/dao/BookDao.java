package com.lzf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzf.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
