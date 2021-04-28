package com.myThread.Demo3;

public class ThreadDaemon extends Thread {
    public ThreadDaemon(String name) {
        super(name);
    }

    public ThreadDaemon() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
