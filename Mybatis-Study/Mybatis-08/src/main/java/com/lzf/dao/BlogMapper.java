package com.lzf.dao;

import com.lzf.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
//    插入数据
    int addBlog(Blog blog);
//    查询博客
    List<Blog> queryBlogIf(Map map);

}
