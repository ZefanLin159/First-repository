package com.myThread.Demo5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable {
    private static int tickets = 100;
    private int x = 0;
    private Lock lock = new ReentrantLock();


    public int getTickets() {
        return tickets;
    }

    @Override
    public void run() {
        while (true) {
            try {

                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
                }
            } finally {
                //避免try里面中的代码出现问题，导致锁没有释放
                lock.unlock();
            }
        }
    }

//    @Override
//    public void run() {
//        while (true) {
//            if (x % 2 == 0) {
//                //这样无法实现（匿名函数相当于每次都创建一把新锁）synchronized (new Object()) {
////                synchronized (obj) {
////                synchronized (this) {//
//                synchronized (SellTicket.class) { //静态方法锁的同步对象是（反射中学）
//                    //t1进来后，就会把这段代码锁起来
//                    //相同票出现多次
//                    if (getTickets() > 0) {
//                        //通过睡眠方法模拟出票时间
//                        try {
//                            Thread.sleep(100);
//                            //t1线程休息100ms
//                            //t2线程抢到了cpu的执行权，t2线程开始执行，执行到这里，t2线程休息100ms
//                            //t3线程抢到了cpu的执行权，t3线程就开始执行，执行到这里，t3线程休息100ms
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        //假设线程按照顺序醒过来
//                        //t1抢到cpu的执行权，在控制台输出：窗口1正在出售第100张票
//                        System.out.println(Thread.currentThread().getName() + "正在出售第" + getTickets() + "张票");
//                        //t2抢到cpu的执行权，在控制台输出：窗口1正在出售第100张票
//                        //t3抢到cpu的执行权，在控制台输出：窗口1正在出售第100张票
//                        tickets--;
//                        //如果这三个线程还是按照顺序来，这里就执行了3次--的操作，最终变成了97
//                    }
//                }
//            } else {
//                sellTicket();
//            }
//            x++;
//        }
//    }
//
//    //  同步方法锁的对象是this
//    private synchronized static void sellTicket() {
//
//        if (tickets > 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//            tickets--;
//        }
//    }

}
