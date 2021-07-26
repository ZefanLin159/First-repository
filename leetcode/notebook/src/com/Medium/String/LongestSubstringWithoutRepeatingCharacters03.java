package com.Medium.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters03 {
    public static void main(String[] args) {
        String s = "pwwkew";
        String s1 = "abcabca";
        String test = "abcdeff";
        System.out.println(lengthOfLongestSubstring(test));
    }

    //错误的做法
    public static int lengthOfLongestSubstring_error(String s) {
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
                count = Math.max(fast - slow, count);
                slow = fast;
            }

        }
        return count;
    }

    public static int lengthOfLongestSubstring(String s) {

//        String test = "abcdeff";最坏情况，时间复杂度为O（2n）
        int count = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
//                我们一般说HashSet是无序的，它既不能保证存储和取出顺序一致，更不能保证自然顺序
                char temp = s.charAt(j);
                set.add(s.charAt(j++));
                count = Math.max(count, j - i);
            } else {
                //删除的是i索引对应的字符
                set.remove(s.charAt(i++));
            }
        }
        return count;
    }
}
