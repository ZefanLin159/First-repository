package com.myThread;

public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Runnable r1 = ()->{
            System.out.println("i am r1");
        };
        Runnable r2 = ()->{
            System.out.println("i am r2");
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

}
