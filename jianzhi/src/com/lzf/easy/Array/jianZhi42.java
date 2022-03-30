package com.lzf.easy.Array;

public class jianZhi42 {
    public static void main(String[] args) {
        jianZhi42 jianZhi42 = new jianZhi42();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxArray = jianZhi42.maxSubArray(nums);
        System.out.println(maxArray);
    }

    //    动态规划
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int greatSum = Integer.MIN_VALUE;//定义返回值
        //分段函数：理解状态方程 dp<0 则赋新值，dp>0则加上新值
        for (int num : nums) {
            if (dp <= 0) {
                dp = num;
            } else {
                dp += num;
            }
            //存储要返回的最大值
            if (dp > greatSum) {
                greatSum = dp;
            }
        }
        return greatSum;
    }

}
