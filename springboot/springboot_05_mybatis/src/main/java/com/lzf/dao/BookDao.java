package com.lzf.dao;

import com.lzf.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//务必注册mapper
@Mapper
public interface BookDao {
    @Select("select * from ssm_db.tbl_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> getByAllBook();
}
