package com.myThread.Demo3;

public class ThreadDaemonDemo {
    public static void main(String[] args) {
        ThreadDaemon td2 = new ThreadDaemon("关羽");
        ThreadDaemon td3 = new ThreadDaemon("张飞");

        //设置主线程为刘备
        Thread.currentThread().setName("刘备");

        //设置守护线程 (注意设置好守护线程后才能启动线程）
        td2.setDaemon(true);
        td3.setDaemon(true);

        td2.start();
        td3.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
