package com.Medium.String;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters03 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        int count = 1;
//        StringBuffer sb = new StringBuffer();
//        sb.append(s.charAt(0));
//        char temp = s.charAt(0);
        int fast = 1;
        int slow = 0;
        for (fast = 0; fast < s.length(); fast++) {
            if (s.charAt(fast) == s.charAt(slow)) {
                char temp = s.charAt(fast);
                char temp2 = s.charAt(slow);
                count = Math.max(fast - slow,count);
                slow = fast;
            }

        }
        return count;
    }
}
