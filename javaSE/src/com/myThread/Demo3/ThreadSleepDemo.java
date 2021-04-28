package com.myThread.Demo3;

public class ThreadSleepDemo {
    public static void main(String[] args) {
        Thread ts1 = new ThreadSleep("曹操");
        Thread ts2 = new ThreadSleep("刘备");
        Thread ts3 = new ThreadSleep("孙权");

        ts1.start();
        ts2.start();
        ts3.start();


    }
}
