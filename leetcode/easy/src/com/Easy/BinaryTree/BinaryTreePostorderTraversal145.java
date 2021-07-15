package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {
    //后序遍历递归
    public List<Integer> postorderTraversal145(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderRecursive(root,list);
        return list;
    }

    public void postOrderRecursive(TreeNode p,List<Integer> list){
        if(p!=null){
            postOrderRecursive(p.left,list);
            postOrderRecursive(p.right,list);
            list.add(p.val);
        }
    }

    //后序遍历迭代(待练习）
    public  List<Integer> postorderTraversal145_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode temp = null;
        while (cur != null ||!stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();//cur的指针指向是在这里更新的，所以下面指向空并不会导致整个逻辑
                if(cur.right == null || cur.right == temp){
                    temp = cur;
                    list.add(cur.val);
                    stack.pop();
                    cur = null;//仿真发现，这里要让cur指针指向空，否则会进入上层的判断，逻辑则混乱了
                }else {
                    cur = cur.right;
                }
            }
        }

        return list;
    }
}
