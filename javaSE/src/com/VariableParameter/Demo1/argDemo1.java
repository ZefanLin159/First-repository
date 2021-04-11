package com.VariableParameter.Demo1;

public class argDemo1 {
    public static void main(String[] args) {
        int sum = sum(10, 20, 30, 40);
        System.out.println(sum);
    }

    //可变参数demo只能放最后
    //将形参封装成数组了
    public static int sum(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
