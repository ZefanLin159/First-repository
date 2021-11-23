package com.lzf.dao;

import com.lzf.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //     查询所有的学生信息以及对应的老师的信息
//    @Select("select * from student")
    List<Student> getStudent();

    List<Student> getStudent2();

}

