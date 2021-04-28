package com.myThread.Demo6;

public class Customer implements Runnable {
    private MilkBox b = new MilkBox();

    public Customer(MilkBox b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            b.getMilk();
        }
    }
}
