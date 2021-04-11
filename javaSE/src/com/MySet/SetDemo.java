package com.MySet;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set = new TreeSet<Integer>();

        Random random = new Random();

        while (set.size() < 10) {
            //nextInt，返回一个0<?<20的int
            int num = random.nextInt(20) + 1;
            set.add(num);
        }

        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
