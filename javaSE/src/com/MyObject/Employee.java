package com.MyObject;

import java.time.LocalDate;
import java.util.Comparator;

public class Employee extends Person  {
    private double salary;
    private LocalDate hireDay;
    public int age;

    public Employee(String name, int age,double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.age = age;
        hireDay = LocalDate.of(year,month,day);
    }

    @Override
    public String getDescription() {
        return null;
    }

    //实现比较接口的类要引入这个方法
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary,other.salary);
    }


}
