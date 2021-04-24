package com.MyObject;

import java.util.Comparator;

public abstract class Person implements Comparable<Employee>{
    public abstract String getDescription();
    private String name;

    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public abstract int compareTo(Employee other);
}
