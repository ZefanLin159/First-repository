package com.myThread.Demo6;

public class BoxDemo {
    public static void main(String[] args) {
        MilkBox b = new MilkBox();

        Producer p = new Producer(b);

        Customer c = new Customer(b);

        Thread t1 = new Thread(p);//生产者线程
        Thread t2 = new Thread(c);//消费者线程

        t1.start();
        t2.start();
    }
}
