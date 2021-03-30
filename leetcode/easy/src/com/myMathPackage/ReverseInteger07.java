package com.myMathPackage;

public class ReverseInteger07 {
    public int reverse(int x) {
        //反转后会出现数据溢出问题，要看清题目提问
        //也就是数据不能超过整形的范围
        //用长整形来保存反转后的长度
        long reverseX = 0;
        if(x!=0) {
            do {
                reverseX = reverseX * 10 + x % 10;
                x /= 10;
            } while (x != 0);
        }
        return reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE ? 0 : (int) reverseX;
    }

    public static void main(String[] args) {


    }
}
