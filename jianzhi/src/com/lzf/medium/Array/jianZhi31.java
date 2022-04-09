package com.lzf.medium.Array;

import java.util.Stack;

public class jianZhi31 {
    public static void main(String[] args) {
        jianZhi31 jianZhi31 = new jianZhi31();
        System.out.println(jianZhi31.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
