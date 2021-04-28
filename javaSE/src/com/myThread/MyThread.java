package com.myThread;

public class MyThread extends Thread {
    public MyThread() {

    }

    public MyThread(String name) {
        //调用父类的带参构造方法
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getName() + ":" + i);
        }
    }

}
