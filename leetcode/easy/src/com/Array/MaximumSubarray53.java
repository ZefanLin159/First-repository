package com.Array;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
        int dp = nums[0];
        int max = nums[0];
        //动态规划思想  https://www.zhihu.com/question/23995189
        //初始化，第一项为最大子序列之和 兼最大值
        //我们考虑 从第一项加到第n项的和 作为子问题
        //我们只需要 取max（子问题之和，0）与下一项相加 得到新的子序列之和。

        //可否理解为前n项之和小于0则取0，
        for (int i = 1; i < nums.length; i++) {
            //Math.max(dp, 0) 相当于舍弃了小于0的序列和重新计数，而大于0的序列和才有效
            dp = Math.max(dp, 0) + nums[i];
            //上式的另一种写法
//            if (dp < 0) {
//                dp = nums[i];
//            } else {
//                dp= dp + nums[i];
//            }
            max = Math.max(dp, max);//将每一次的最大子序列之和上一次的进行比较
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2, 1, 3, -3, 3, 2, 1, -5, 4};
    }
}

class Solution53{
}