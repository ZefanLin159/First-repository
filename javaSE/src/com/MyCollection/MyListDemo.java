package com.MyCollection;

import sun.nio.cs.MS1250;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyListDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        Student s1 = new Student("lqx", 30);
        Student s2 = new Student("lpj", 31);
        Student s3 = new Student("hz", 32);
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Iterator<Student> it = list.iterator();
        //迭代器遍历过程中，不可增删改,非常容易出现线程问题
        while (it.hasNext()) {
            Student s = it.next();
            if(s.equals(s2)){
                list.remove(s3);
            }
            System.out.println(s);
        }

        System.out.println("---------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("------------");
        System.out.println(list);
    }
}


