package com.myThread;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("高铁");
        t2.setName("飞机");
        t1.start();
        t2.start();

        //currentThread() 返回当前正在执行的线程对象的引用
        System.out.println(Thread.currentThread().getName());
    }
}

