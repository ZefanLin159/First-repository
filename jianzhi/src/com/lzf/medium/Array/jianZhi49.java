package com.lzf.medium.Array;

public class jianZhi49 {
    public static void main(String[] args) {
        jianZhi49 jianZhi49 = new jianZhi49();
        System.out.println(jianZhi49.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int minA = dp[a] * 2, minB = dp[b] * 3, minC = dp[c] * 5;
            dp[i] = Math.min(minA, Math.min(minB, minC));
//            三个都要判断，因为abc指针可能重叠
            if (dp[i] == minA) a++;
            if (dp[i] == minB) b++;
            if (dp[i] == minC) c++;
        }

        return dp[n - 1];
    }
}
