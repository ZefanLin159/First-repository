package com.MyInterface;


import javax.swing.*;
import java.awt.event.ActionListener;

public class LambdaTest3 {
    public static void main(String[] args) {

    }

    public static void countDown(int start, int delay) {
        ActionListener listener = e -> {
//          start--;//Variable used in lambda expression should be final or effectively final
            System.out.println(start);
        };
        new Timer(delay, listener).start();
    }

    public static void repeat(String text, int count) {
        for (int i = 1; i <= count; i++) {
            ActionListener listener = e -> {
//                System.out.println(i+":"+text);//lambda函数中的参数不可变（final)，无论这个参数是在外部还是在内部
            };
        }
    }
    

}
