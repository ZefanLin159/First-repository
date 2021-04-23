package com.MyObject;

import java.util.Random;

public class MyClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Employee e = new Employee("zf", 5000.0, 1994, 11, 04);
        Class cl = e.getClass();//获得类名
        String name1 = e.getName();
        System.out.println(e.getClass().getName() + ":" + name1);

        Random generator = new Random();
        Class cl1 = generator.getClass();
        String name = cl.getName();
        System.out.println("name = " + name);

        String className = "java.util.Random";
        Class cl2 = Class.forName(className);//如果类名不存在则会抛出异常
        System.out.println("cl2 = " + cl2);
    }
}
