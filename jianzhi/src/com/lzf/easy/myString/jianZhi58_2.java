package com.lzf.easy.myString;

public class jianZhi58_2 {
    public static void main(String[] args) {
        jianZhi58_2 jianZhi58_2 = new jianZhi58_2();
        jianZhi58_2.reverseLeftWords("lrloseumgh", 6);
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder str = new StringBuilder();
        int left = 0, right = left;
        while (right < s.length()) {
//            substring左闭右开
            while (right < s.length() && (right - left) < n) right++;
            StringBuilder test1 = str.append(s.substring(right, s.length()));
//            System.out.println(test1.toString());
            StringBuilder test2 = str.append(s.substring(left, right));
//            System.out.println(test2.toString());
            break;
        }
        return str.toString();
    }

}
