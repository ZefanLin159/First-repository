package com.MyInterface;

import java.util.Arrays;

public class LambdaTest2 {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        //   Arrays.sort(planets,(x,y)->x.compareToIgnoreCase(y));
        Arrays.sort(planets,String::compareToIgnoreCase);/* 方法引用，等价于上式 */
        System.out.println(Arrays.toString(planets));

        /*构造器引用*/


    }
}
