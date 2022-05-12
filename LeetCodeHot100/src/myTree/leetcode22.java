package myTree;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public static void main(String[] args) {
        leetcode22 leetcode22 = new leetcode22();
        System.out.println(leetcode22.generateParenthesis(2));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
//        爬树枝的虫子
        String s = "";
        recur(list, s, left, right, n);
        return list;
    }

    private void recur(List<String> list, String s, int left, int right, int n) {
        //判断回溯是否到底
        if (s.length() == n*2) {
            list.add(s);
//            添加完数据后返回
            return;
        }

        //如果左括号数小于n,则可以继续加左括号
        if (left < n) {
            recur(list, s + "(", left + 1, right, n);
        }
        //如果右括号数量小于左括号，则也可以选择加入右括号
        if (right < left) {
            recur(list, s + ")", left, right + 1, n);
        }
    }
}
