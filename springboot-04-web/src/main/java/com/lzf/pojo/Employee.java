package com.lzf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0 NV
    private Department department;
    private Date birth;
}
