package com.MyException;

public class MyTeacher {
    public void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("数据无意义");
        } else {
            System.out.println("数组正常");
        }
    }
}
