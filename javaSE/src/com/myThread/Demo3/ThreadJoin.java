package com.myThread.Demo3;

public class ThreadJoin extends Thread{
    public ThreadJoin(String name) {
        super(name);
    }

    public ThreadJoin() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
