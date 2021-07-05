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
        for (i = 0, j = arrayList.size() - 1; i <= j; i++, j--) {
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
        int count = (int) (1 + Math.log(test) / Math.log(10));
        System.out.println(count);
    }
    //需要额外空间，效果不好，不是最优解
    public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        boolean isPal = false;
        StringBuilder s = new StringBuilder();
        int temp;
        while (x>0){
            temp = x % 10;
            s.append(temp);
            x/=10;
        }
        String newS = s.toString();
        int i = 0,j = newS.length()-1;
        while (i<j){
            if(newS.charAt(i) == newS.charAt(j)){
                i++;
                j--;
                isPal = true;
            }else {
                isPal = false;
                break;
            }
        }
        return isPal;
    }
    //利用第七题的解法
    public static boolean isPalindrome2(int x){
        if (x < 0) return false;
        boolean isPal = false;

        int i = 0;
        long y = x;
        int newX = x;
        while(y>0){
            y/=10;
            i++;
        }
        int lowBit = 0;
        while(newX>0){
            lowBit = newX%10;
            newX = newX/10;
            y += lowBit*(long)Math.pow(10,i-1);
            i--;
        }
        if(y>=Integer.MAX_VALUE) return false;
        if(x == y) isPal = true;
        return isPal;
    }
}
