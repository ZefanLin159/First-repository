package com.myThread.Demo4;

import com.myThread.Demo3.ThreadJoin;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();//这里是一个实现Runnable接口的对象
        Thread t1 = new Thread(mr, "高铁");//传入一个实现Runnable接口的对象
        Thread t2 = new Thread(mr, "飞机");

        t1.start();
        t2.start();
    }
}
