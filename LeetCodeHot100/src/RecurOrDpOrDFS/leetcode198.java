package RecurOrDpOrDFS;

//打家劫舍
public class leetcode198 {
    public static void main(String[] args) {
        leetcode198 lc198 = new leetcode198();
        System.out.println(lc198.rob(new int[]{2,7,9,3,1}));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
