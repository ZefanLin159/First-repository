package com.lzf.medium.myMath;

public class jianZhi20 {

    public boolean isNumber(String s) {

        if (s == null || s.length() == 0) return false;
        int i = 0;
        char[] str = s.trim().toCharArray();
        boolean isNum = false, isDot = false, isExponent = false;
        while (i < str.length) {
            if (str[i] >= '0' && str[i] <= '9') {
                isNum = true;
            } else if (str[i] == '.') {
                if ( isDot|| isExponent) return false;
                isDot = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (!isNum || isExponent) return false;
                isExponent = true;
                isNum = false;
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
            } else return false;
            i++;

        }
        return isNum;
    }
}
