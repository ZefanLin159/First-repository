package com.myThread.Demo6;

public class MilkBox {
    private int milk = 0;
    private boolean state = false;

    //IllegalMonitorStateException不加同步关键字会抛出该异常
    //提供存储牛奶和获取牛奶的操作
    public synchronized void setMilk(int milk) {
        //如果有牛奶，等待消费
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶，就生产牛奶
        this.milk = milk;
        System.out.println("送奶工将第" + this.milk + "瓶奶放入奶箱");
        //生产完毕之后，修改奶箱状态
        state = true;

        //唤醒其他等待线程
        notifyAll();
    }

    public synchronized void getMilk() {
        //如果没有牛奶，就等待生产
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果有牛奶，就消费牛奶
        System.out.println("用户拿到第" + this.milk + "瓶奶");
        state = false;
        notifyAll();
    }
}
