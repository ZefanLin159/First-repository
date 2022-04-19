package com.lzf.medium.dp;

public class jianZhi46 {

    public static void main(String[] args) {
        jianZhi46 jianZhi46 = new jianZhi46();
        System.out.println(jianZhi46.translateNum(25));
    }

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (str.charAt(i - 2) == '1' || str.charAt(i - 2) == '2' && str.charAt(i - 1) < '6') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
