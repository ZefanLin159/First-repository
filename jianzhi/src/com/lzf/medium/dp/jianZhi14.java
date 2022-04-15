package com.lzf.medium.dp;

public class jianZhi14 {
    public static void main(String[] args) {
        jianZhi14 jz14 = new jianZhi14();
        System.out.println(jz14.cuttingRope(10));
    }

    //    动态规划
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) return 0;
        if (n == 2) return 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int max = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(max, dp[i]);

            }
        }
        return dp[n];
    }

    //    贪心算法
    public int cuttingRope1(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int i = 0;
        while (n >= 3) {
            n -= 3;
            i++;
        }
        int timesOf3 = n % 3;
        if (timesOf3 == 0) {
            return (int) Math.pow(3, i);
        }
        if (timesOf3 == 1) {
            return (int) Math.pow(3, i - 1) * 4;
        }
        if (timesOf3 == 2) {
            return (int) Math.pow(3, i) * 2;

        }
        return 0;

    }

}
