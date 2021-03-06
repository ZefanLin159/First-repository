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
        int profit = 0;
        int dp = prices[0];
        for(int i =1;i<prices.length;i++){
            
        }
        return profit;
    }
}