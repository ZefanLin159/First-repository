package com.myThread.Demo6;

public class Producer implements Runnable {
    private MilkBox b;

    public Producer(MilkBox b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            b.setMilk(i);
        }
    }
}
