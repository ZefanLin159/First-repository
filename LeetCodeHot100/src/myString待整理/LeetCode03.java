package myString待整理;

import java.util.HashMap;
import java.util.Scanner;


public class LeetCode03 {
    public static void main(String[] args) {
        LeetCode03 lc03 = new LeetCode03();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int maxLen = lc03.lengthOfLongestSubstring(s);
        System.out.println(maxLen);

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = -1, j = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[len];
        char[] c = s.toCharArray();
        dp[0] = 1;
        map.put(c[0], 0);
        for (j = 1; j < c.length; j++) {
            if (map.containsKey(c[j])) {
                i = Math.max(i, map.getOrDefault(c[j], 0));
            }
            map.put(c[j], j);
            if (dp[j - 1] < j - i) {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = dp[j - 1];
            }
        }
        return dp[len - 1];


    }
}
