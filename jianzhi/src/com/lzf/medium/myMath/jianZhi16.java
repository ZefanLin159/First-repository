package com.lzf.medium.myMath;

public class jianZhi16 {
    public static void main(String[] args) {
        jianZhi16 jianZhi16 = new jianZhi16();
        System.out.println(jianZhi16.myPow(3.0, 9));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1.0;
        if (n == 1) return x;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;

        }
        return res;
    }
    //    有少数测试案例通过不了
//    public double myPow(double x, int n) {
//        if (x == 0) return 0;
//        if (n == 0) return 1;
//        long b = n;
//        double sum = 1;
//        if (b > 0) {
//            for (long i = 1; i <= b; i++) {
//                sum *= x;
//            }
//        } else {
//            long exponent = -b;
//            for (int i = 1; i <= exponent; i++) {
//                sum *= x;
//
//            }
//            sum = 1.0 / sum;
//
//        }
//        return sum;
//    }

}
