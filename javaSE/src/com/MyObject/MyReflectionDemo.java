package com.MyObject;

import java.lang.reflect.Field;

public class MyReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee harry = new Employee("Harry Hacker",40,35000,1989,1,1);
        Class cl = harry.getClass();
//        Field f = cl.getDeclaredField("name");
//        Object v = f.get(harry);

        Field age = cl.getDeclaredField("age");
        Object o = age.get(harry);

        System.out.println(age.toString());
        System.out.println(o.toString());
    }
}
