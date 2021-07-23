package com.Easy.myMathPackage;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        System.out.println(climbStairs1(7));
    }

    //Recursion
    public int climbStairs(int n) {
        //多申请一个空间可以保证键值（数组下标）与n个楼梯对应，不需再考虑数组下标问题，是个小技巧
        int[] memo = new int[n + 1];
        return climbStairsRecursion(n, memo);
    }

    private int climbStairsRecursion(int n, int[] memo) {
        if (n == 1 || n == 2) return n;
        int n1 = 0;
        int n2 = 0;
        if (memo[n - 1] == 0) {
            n1 = climbStairsRecursion(n - 1, memo);
            memo[n - 1] = n1;
        } else {
            n1 = memo[n - 1];
        }

        if (memo[n - 2] == 0) {
            n2 = climbStairsRecursion(n - 2, memo);
            memo[n - 2] = n2;
        } else {
            n2 = memo[n - 2];
        }

        return n1 + n2;
    }


    public static int climbStairs1(int n) {
        if (n == 1 || n == 2) return n;
        //常规的动态规划，需要O(N)的空间复杂度
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int i = 2;
        for (; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];

        //优化后的动态规划
//        int n1 = 1;
//        int n2 = 2;
//        int dp = 0;
//        //动态规划思想，我们只需要一直更新n1和n2的数据即可
//        for (int i = 3; i <= n; i++) {
//            dp = n1 + n2;
//            n1 = n2;
//            n2 = dp;
//        }
//        return dp;

    }
}
