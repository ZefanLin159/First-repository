package com.MyCollection;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSetDemo2 {
    public static void main(String[] args) {
        //比较器实现自然排序，利用了匿名类，这样就不用让Students实现Comparable（比较器）接口
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });

        Student s1 = new Student("hz", 21);
        Student s2 = new Student("lzg", 21);
        Student s3 = new Student("lzf", 27);
        Student s4 = new Student("lpj", 25);
        Student s5 = new Student("hjx", 26);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s5);
        ts.add(s4);

        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }


    }
}
