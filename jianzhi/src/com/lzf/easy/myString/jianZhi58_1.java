package com.lzf.easy.myString;

public class jianZhi58_1 {
    public static void main(String[] args) {
        jianZhi58_1 jianZhi58 = new jianZhi58_1();
        System.out.println(jianZhi58.reverseWords("  hello world!  "));
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder str = new StringBuilder();
        int j = s.length() - 1, i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            str.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return str.toString();
//        return str.toString().trim();

    }

}
