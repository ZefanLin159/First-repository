package com.lzf.easy.myString;

import java.util.HashMap;

public class jianZhi50 {
    public static void main(String[] args) {
        jianZhi50 jianZhi50 = new jianZhi50();
        System.out.println(jianZhi50.firstUniqChar("abaccdeff"));
    }

    public char firstUniqChar(String s) {
//        改进，用boolean代替Integer
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            map.put(c, !map.containsKey(c));
        for (char c : sc)
            if (map.get(c)) return c;
        return ' ';
    }
}
