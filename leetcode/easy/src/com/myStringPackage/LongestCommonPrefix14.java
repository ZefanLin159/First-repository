package com.myStringPackage;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix1(strings));
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            min = Math.min(strs[i].length(), min);
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isSame = false;
        for (int j = 0; j < min; j++) {
            char letter = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (letter == strs[i].charAt(j)) {
                    isSame = true;
                } else {
                    isSame = false;
                    break;
                }
            }
            if (isSame == true) {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        //注意长度为1的情况
        if (strs.length == 1) return strs[0];
        boolean equalFlag = true;
        String str = new String();
        String maxStr = new String("");
        int i = 1, j = 0;
//        最小长度其实可以一句话解决
//        int minLength = strs[0].length();
//        //还是要找到最小长度
//        for (i = 1; i < strs.length; i++) {
//            if (strs[i].length() < minLength)
//                minLength = strs[i].length();
//        }
        for (; j < strs[0].length(); j++) {
            char temp = strs[0].charAt(j);
            for (i = 1; i < strs.length; i++) {
                if (j == strs[i].length() || temp != strs[i].charAt(j)) {
                    equalFlag = false;
                    break;
                }
                if (i == strs.length - 1) {

                    maxStr += strs[i].charAt(j);
                }

            }
            if (equalFlag == false) break;
        }

        return maxStr;
    }


}
