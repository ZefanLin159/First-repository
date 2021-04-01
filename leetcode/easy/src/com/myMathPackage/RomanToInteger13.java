package com.myMathPackage;

import java.util.Stack;

public class RomanToInteger13 {
    //这题很简单，思路和我的一样，巧妙的是不需要额外堆栈的O(N)空间
    // 直接用字符串charAt这个函数来控制指针位置即可
    public static int romanToInt1(String s) {
        int val = 0;
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            char temp = s.charAt(i);
            switch (temp) {
                case 'I':
                    val += 1;
                    break;
                case 'V':
                    if (i != 0 && s.charAt(i - 1) == 'I') {
                        val += 4;
                        i--;
                    } else val += 5;
                    break;
                case 'X':
                    if (i != 0 && s.charAt(i - 1) == 'I') {
                        val += 9;
                        i--;
                    } else val += 10;
                    break;
                case 'L':
                    if (i != 0 && s.charAt(i - 1) == 'X') {
                        val += 40;
                        i--;
                    } else val += 50;
                    break;
                case 'C':
                    if (i != 0 && s.charAt(i - 1) == 'X') {
                        val += 90;
                        i--;
                    } else val += 100;
                    break;
                case 'D':
                    if (i != 0 && s.charAt(i - 1) == 'C') {
                        val += 400;
                        i--;
                    } else val += 500;
                    break;
                case 'M':
                    if (i != 0 && s.charAt(i - 1) == 'C') {
                        val += 900;
                        i--;
                    } else val += 1000;
                    break;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt1("XXVII"));
//        System.out.println(romanToInt("IV"));
    }
}
