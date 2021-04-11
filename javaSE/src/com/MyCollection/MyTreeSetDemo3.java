package com.MyCollection;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSetDemo3 {
    public static void main(String[] args) {
        TreeSet<StudentsDemo> ts = new TreeSet<StudentsDemo>(new Comparator<StudentsDemo>() {
            @Override
            public int compare(StudentsDemo o1, StudentsDemo o2) {
                int num = o2.getMathScore() - o1.getMathScore();
                int num2 = num == 0 ? o2.getChineseScore() - o1.getChineseScore() : num;
                int num3 = num2 == 0 ? o2.getName().compareTo(o1.getName()) : num2;
                return num3;
            }
        });

        StudentsDemo s1 = new StudentsDemo("lzf", 80, 90);
        StudentsDemo s2 = new StudentsDemo("lzg", 50, 100);
        StudentsDemo s3 = new StudentsDemo("cjx", 100, 30);
        StudentsDemo s4 = new StudentsDemo("lxk", 70, 90);
        StudentsDemo s5 = new StudentsDemo("lxx", 100, 30);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        for (StudentsDemo s : ts) {
            System.out.println(s.getName() + "," + s.getChineseScore() + "," + s.getMathScore());
        }
    }
}
