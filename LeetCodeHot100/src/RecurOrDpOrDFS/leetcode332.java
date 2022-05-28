package RecurOrDpOrDFS;

import java.util.ArrayList;
import java.util.List;

//零钱兑换
public class leetcode332 {
    public static void main(String[] args) {
        leetcode332 lc332 = new leetcode332();
        System.out.println(lc332.coinChange(new int[]{1, 2}, 3));
    }

    //最蠢的全排列方法会超出时间限制

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];

        return findWay(coins, amount);
    }

    //    不是太理解
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

    public int findWay(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[amount] = Integer.MAX_VALUE;
        dp[0] = 0;
//        dp数组的遍历
        for (int i = 1; i < dp.length; i++) {
//            i-coins[j]的遍历
            for (int j = 0; j < coins.length ; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
