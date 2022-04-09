package com.lzf.medium.Array;

public class jianzhi64 {
    public static void main(String[] args) {
        jianzhi64 jianzhi64 = new jianzhi64();
        System.out.println(jianzhi64.maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9}));
    }

    public int maxProfit(int[] prices) {
        int slow = 0, fast = 1, profit = 0;
        for (fast = 1; fast < prices.length; fast++) {
            if (prices[fast] > prices[slow]) profit = Math.max(profit, prices[fast] - prices[slow]);
            else slow = fast;
        }
        return profit;
    }
}
