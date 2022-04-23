package com.lzf.medium.myString;

public class jianZhi67 {
    public static void main(String[] args) {
        jianZhi67 jianZhi67 = new jianZhi67();
        System.out.println(jianZhi67.strToInt("200000000000000000"));
    }

    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0 ) return 0;
 //        越界判断
        int boundVal = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        int res = 0;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > boundVal || res == boundVal && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}


//    大数越界问题没有解决，输入“2000000000000000000000000”报错

//    public int strToInt(String str) {
//        if(str == null || str.length() == 0) return 0;
//        str = str.trim();
//        StringBuilder sb = new StringBuilder();
//        boolean polarFlag = true;
//        int num = 0;
//        char[] charArray = str.toCharArray();
//        if(charArray.length == 0) return 0;
//        if(charArray.length == 1){
//            if(charArray[0] =='-' || charArray[0] == '+')
//                return 0;
//        }
//        if (charArray[0] == '-') {
//            polarFlag = false;
//        }
//        if (charArray[0] == '+' || charArray[0] == '-' || charArray[0] >= '0' && charArray[0] <= '9') {
//            if (charArray[0] >= '0') {
//                sb.append(charArray[0]);
//            }
//            for (int i = 1; i < charArray.length; i++) {
//                if (charArray[i] >= '0' && charArray[i] <= '9') {
//                    sb.append(charArray[i]);
//                } else {
//                    break;
//                }
//            }
//
//        } else
//            return 0;
//        String s = sb.toString();
//        if(s == null || s.length() == 0) return 0;
//        long test = Long.parseLong(s);
//        if (polarFlag) {
//            num = Long.parseLong(s) >= Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.parseInt(s);
//        } else {
//            num = -Long.parseLong(s) <= Integer.MIN_VALUE ? Integer.MIN_VALUE : -Integer.parseInt(s);
//        }
//        return (Integer) num;
//    }
