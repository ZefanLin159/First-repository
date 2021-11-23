package com.lzf.dao;

import com.lzf.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface TeacherMapper {
//    @Select("select * from `teacher` where id = #{tid}")
//    Teacher getTeacher(@Param("tid") int id);
    Teacher getTeacher(int id);
}

