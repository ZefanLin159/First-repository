package com.myThread.Demo4;
//实现接口的方式更合适一些
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":"+i);
        }
    }
}
