package com.myThread.Demo1;

public class MyMoreThreads {
    public static void main(String[] args) {
        for(int i = 0;i<2;i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
