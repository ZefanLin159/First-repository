package com.MyCollection;

public class StudentsDemo {
    private String name;
    private int ChineseScore;
    private int MathScore;

    public StudentsDemo(String name, int chineseScore, int mathScore) {
        this.name = name;
        ChineseScore = chineseScore;
        MathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public int getMathScore() {
        return MathScore;
    }

    public int getChineseScore() {
        return ChineseScore;
    }

    @Override
    public String toString() {
        return "StudentsDemo{" +
                "name='" + name + '\'' +
                ", ChineseScore=" + ChineseScore +
                ", MathScore=" + MathScore +
                '}';
    }
}
