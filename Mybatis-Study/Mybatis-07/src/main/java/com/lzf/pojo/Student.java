package com.lzf.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联一个老师(面向对象的一个思想，好想法！）
    private int tid;
}
