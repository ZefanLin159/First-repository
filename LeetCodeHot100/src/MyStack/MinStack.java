package MyStack;

import java.util.Stack;

//最小栈
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }

    Stack<Integer> stack1;
    Stack<Integer> minStack;

    public MinStack() {
        stack1 = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (!minStack.isEmpty()) {
            if (minStack.peek() >= val) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack1.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
