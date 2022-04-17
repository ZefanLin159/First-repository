package com.lzf.easy.myStack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1, stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();

    }
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }
    public void pop() {
        int val = stack1.pop();
        if (stack2.peek() == val) {
            stack2.pop();
        }
    }
    public int top() {
        return stack1.peek();
    }
    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        int minVal= minStack.min();
        System.out.println(minVal);
        minStack.pop();
        int minVal1= minStack.min();
        System.out.println(minVal1);


    }





}
