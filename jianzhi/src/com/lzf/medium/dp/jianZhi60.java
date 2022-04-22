package com.lzf.medium.dp;

import java.util.Arrays;

public class jianZhi60 {
    public static void main(String[] args) {
        jianZhi60 jianZhi60 = new jianZhi60();
        System.out.println(Arrays.toString(jianZhi60.dicesProbability(2)));
    }

    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1.0 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0) { //这里好像是j-k>0为什么？
                        dp[i][j] += dp[i-1][j - k] / 6.0;
                    } else
                        break;
                }
            }
        }
        double[] res = new double[5 * n + 1];
        for (int i = 0; i < 5 * n +1; i++) {
            res[i] = dp[n][n + i];
        }
        return res;
    }
}
