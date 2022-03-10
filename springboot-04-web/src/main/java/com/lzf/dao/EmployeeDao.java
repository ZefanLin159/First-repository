package com.lzf.dao;

import com.lzf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    //    模拟数据库中的数据
    private static Map<Integer, Employee> employeeMap = null;

    //    员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap = new HashMap<Integer, Employee>();

    }
}
