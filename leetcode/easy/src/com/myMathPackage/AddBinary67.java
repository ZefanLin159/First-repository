package com.myMathPackage;

public class AddBinary67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String c = addBinary(a, b);
        System.out.println(c);
    }

    public static String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        if (b.length() > a.length()) {
            String t = a;
            a = b;
            b = t;
        }
        while (b.length() < a.length()) {
            b = "0" + b;
        }

        StringBuilder stringBuilder = new StringBuilder("");
        int plus = 0;//设置进位标志
        for (int i = a.length() - 1; i >= 0; i--) {
            int a_num = a.charAt(i) - '0';
            int b_num = b.charAt(i) - '0';

            int temp = a_num + b_num + plus;  //这里切记要把进位加上去
            if (temp >= 2) {
                temp = temp % 2;
                plus = 1;
            } else {
                plus = 0;
            }
            stringBuilder.append(temp);
        }
        if (plus > 0) { //最后要判断一下是否溢出
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
