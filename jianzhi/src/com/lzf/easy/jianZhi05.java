package com.lzf.easy;

public class jianZhi05 {
    public static void main(String[] args) {
        String s = "We are happy. ";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');

            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
