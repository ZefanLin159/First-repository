package com.MyException;

import java.util.Scanner;

public class ScoreTest {
    public static void main(String[] args) {
        MyTeacher teacher = new MyTeacher();
        //系统输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数:");
        int score = sc.nextInt();
        try {
            teacher.checkScore(score);
        } catch (ScoreException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
