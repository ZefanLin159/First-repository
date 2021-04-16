package com.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }

    public static int fibonacci(int n) {
        int sum;
        if (n == 1 || n == 2) {
            sum = 1;
        } else {
            sum = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return sum;
    }
}
