package com.Array;

public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int profit = 0;
        int fast = 0;
        int slow = 0;
        //本题使用双指针做的，看了一点提示，最初定义的是快慢针，目前感觉区别不是很大
        //思路如下，当快针指向的数据大于慢针的时候，则计算利润和当前利润差的最大值
        //当快针指向的数据比慢针小的时候，则让慢针指向快针的数据（说明买入的价格更低，而我们可以获得更高的利润）
        for (fast = 1; fast < prices.length; fast++) {
            if (prices[fast] < prices[slow]) {
                slow = fast;
            } else {
                profit = Math.max(profit, prices[fast] - prices[slow]);
            }
        }

        return profit;
    }
}

class Solution123 {
    public int maxProfit(int[] prices) {
        //动态规划解法
        int maxProfit = 0;
        int dp = 0;
        for (int i = 1; i < prices.length; i++) {
            //构建新数组，数组含义为第i天和前一天的相对差，但事实上每次都会覆盖掉
            int num = prices[i] - prices[i - 1];
            //题目这样设计可以变成53题求子列和问题
            //Kadane algorithm
            //此处的意义为连续的和比如对应第 3 到 第 6 天加起来的和，那对应的买入卖出其实就是第 2 天买入，第 6 天卖出
            //dp = max（当前的利润，当前利润和之前的相对利润和） max可以保证不亏本卖出
            //T^T这不是正常人能想到的思路，这方法不是很理解，先跳过
            dp = Math.max(num, dp + num);
            maxProfit = Math.max(maxProfit, dp);
        }
        return maxProfit;
    }
}