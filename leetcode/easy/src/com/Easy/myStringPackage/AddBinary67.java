package com.Easy.myStringPackage;

public class AddBinary67 {
    public static void main(String[] args) {
        AddBinary67 addBinary67 = new AddBinary67();
        System.out.println(addBinary67.addBinary("111", "11"));
    }

    //毫无思路
    public String addBinary(String a, String b) {
        //把长度短的放到字符串b中
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        //补齐字符串
        while (b.length() < a.length()) {
            b = '0' + b;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = a.length()-1;i>=0;i--){
            //得到int型（方便加减）的一个好方法，char型减char型（仅限‘0’-‘9’）这组数字
            int aBinary = a.charAt(i) - '0';
            int bBinary = b.charAt(i) - '0';
            int temp = aBinary+bBinary+carry;
            //处理二进制加减的一个好方法
            if(temp>=2){
                temp=temp%2;
                carry = 1;
            }
            //StringBuilder的用法，学习一下，向后增加一个数据
            sb.append(temp);
        }
        if(carry == 1) sb.append(1);
        //最后将得到的字符串再进行一个反转并利用继承Object的toString（）进行返回
        return sb.reverse().toString();
    }


}
