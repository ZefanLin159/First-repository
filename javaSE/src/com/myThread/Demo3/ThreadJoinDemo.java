package com.myThread.Demo3;

public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread ts1 = new ThreadJoin("康熙");
        Thread ts2 = new ThreadJoin("四阿哥");
        Thread ts3 = new ThreadJoin("五阿哥");


        ts1.start();
        try {
            ts1.join();//等待线程1结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ts2.start();
        ts3.start();
    }
}
