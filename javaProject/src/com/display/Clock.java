package com.display;

public class Clock {
    private Display hours = new Display(24);
    private Display minutes = new Display(60);

    public void start() {
        while (true) {
            minutes.increase();
            if (minutes.getValue() == 0) {
                hours.increase();
            }
            System.out.printf(" %02d: %02d \n", hours.getValue(), minutes.getValue());
        }
    }

    public static void main(String args[]) {
        Clock clock = new Clock();
        clock.start();
    }
}
