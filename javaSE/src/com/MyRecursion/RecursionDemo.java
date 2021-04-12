package com.MyRecursion;

public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int n) {
        int sum = 1;
        if (n == 1) {
            sum = 1;
        } else {
            sum = n * factorial(n - 1);
        }
        return sum;
    }
}
