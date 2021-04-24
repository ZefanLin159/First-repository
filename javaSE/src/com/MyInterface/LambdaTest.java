package com.MyInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("按字典顺序排列");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("按字符长度排列");
        //这里的lambda表达式可以实现 Arrays.sort(planets, Comparator.comparingInt(String::length));
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        // lambda表达式 等价于实现下面这个函数
        // Object变量不能用lambda表达式
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("在...时候，时间是" + new Date());
//        }
        Timer timer = new Timer(1000, e -> System.out.println("时间是" + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "退出程序");
        System.exit(0);
    }
}
