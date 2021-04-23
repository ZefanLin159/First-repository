package com.MyObject;

import java.time.LocalDate;

public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name,double salary, int year,int month,int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    @Override
    public String getDescription() {
        return null;
    }


}
