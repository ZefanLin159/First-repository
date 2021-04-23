package com.myStringPackage;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "a man, a plan, a canal: Panama";
        String s1 = "race a car";
        System.out.println(isPalindrome(s));
//        System.out.println((byte) '0');
//        System.out.println((byte) 'a');
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        //统一转换为小写
        s = s.toLowerCase();
        boolean flag = true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char tmp = s.charAt(i);
            char tmp1 = s.charAt(j);
            if (!isAlphaNum(s.charAt(i))) {
                i++;
            } else if (!isAlphaNum(s.charAt(j))) {
                j--;
            } else if (s.charAt(i) != s.charAt(j)) {
                flag = false;
                break;
            } else {
                i++;
                j--;
            }
        }

        return flag;
    }
    //利用逆否命题来进行判断更好一些
    private static boolean isAlphaNum(char c) {
        boolean flag = false;
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            flag = true;
        }
        return flag;
    }
}
