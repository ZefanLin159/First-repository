package com.lzf.medium.dp;

import java.util.HashMap;
import java.util.Map;

public class jianZhi48 {
    public static void main(String[] args) {
        jianZhi48 jianZhi48 = new jianZhi48();
        System.out.println(jianZhi48.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        int i = -1;
        for (int j = 1; j < dp.length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            if (dp[j - 1] < j - i) {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = dp[j - 1];
            }
        }
        return dp[len - 1];

    }


}
