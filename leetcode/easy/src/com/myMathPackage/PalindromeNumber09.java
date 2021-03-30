package com.myMathPackage;

import java.util.ArrayList;

public class PalindromeNumber09 {
    public static boolean isPalindrome(int x) {
        //有待优化，怎么不申请新的空间呢
        if (x < 0) return false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean flag = true;
        int i, j;
        do {
            i = x % 10;
            x = x / 10;
            arrayList.add(i);
        } while (x > 0);
        for (i = 0, j = arrayList.size()-1; i <= j; i++, j--) {
            if (arrayList.get(i) != arrayList.get(j)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(-101));
//        System.out.println(isPalindrome(11));
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(1221));
//        System.out.println(isPalindrome(121));
        int test = 1221;
        //精彩
        int count = (int)(1+Math.log(test)/Math.log(10));
        System.out.println(count);
    }
}
