package com.myStringPackage;

public class LengthOfLastWord58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        if (s == "") return 0;
        int count = 0;
        //这是用了一个寄存器计算最后空格字符串的方法，下面有优化
//        int tempCount = 0;
//        for (int j = s.length() - 1; j >= 0; j--) {
//            if (s.charAt(j) == ' ') {
//                tempCount++;
//            } else break;
//        }
//
//        for (int i = 0; i < s.length() - tempCount; i++) {
//            if (s.charAt(i) == ' ') count = 0;
//            else count++;
//        }


        //看到了倒序后自己想出来的一个好方法
        //我们可以倒序之后用一个标志位，如果到最后一个单词的最后一个字母了，则令这个空格标志位为false。
        //遍历完这个字母再判断是否为空格以及标志位是否已经为false，则退出（可以避免单词后面全为空格的极端情况）
        //如“a     “
        boolean spaceFlag = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && spaceFlag == false) {
                break;
            }
            if (s.charAt(i) != ' ') {
                count++;
                spaceFlag = false;
            }
        }

        return count;
    }
}
