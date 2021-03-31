package com.myStack;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
    }

    public static boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    bracket.push(c);
                    break;
                case ')':
                    if (!bracket.empty()) {
                        if (bracket.peek() == '(') {
                            bracket.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    //这里不要漏写break;要注意
                    break;
                case '}':
                    if (!bracket.empty()) {
                        if (bracket.peek() == '{') {
                            bracket.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    //这里不要漏写break;要注意
                    break;
                case ']':
                    if (!bracket.empty()) {
                        if (bracket.peek() == '[') {
                            bracket.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    //这里不要漏写break;要注意
                    break;
            }
        }
        //这里return ture是不正确的，因为有可能出现一种情况，就是"["的这种输入，那么上面的for循环进一次就会退出
        //那么堆栈非空，那么括号肯定不封闭
        return bracket.empty();
    }
}
