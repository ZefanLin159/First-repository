package com.MyCollection;

public class Student {// implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //如果要实现自然排序，就必须让类（Student）去实现Comparable接口
    //自然排序
//    @Override
//    public int compareTo(Student s) {
//        //注意输出顺序
//        int num = this.age - s.age;
//        int num2 = num == 0?this.name.compareTo(s.name):num;
//        return num2;
//    }
}
