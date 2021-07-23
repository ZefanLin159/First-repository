package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    //前序遍历递归
    public List<Integer> preorderTraversal144(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderRecursive(root, list);
        return list;
    }

    public void preOrderRecursive(TreeNode p, List<Integer> list) {
        if (p != null) {
            list.add(p.val);
            preOrderRecursive(p.left, list);
            preOrderRecursive(p.right, list);
        }
    }

    //前序遍历迭代
    public List<Integer> preorderTraversal144_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {//这里是or
            //前序和中序的区别  在于list.add位置的区别，切记，切记
            if (temp != null) {
                list.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            } else {
//            if(!stack.isEmpty()){//前序遍历不能利用栈来判断，只能用temp指向来判断，eg[1,null,2,3];
                temp = stack.pop();
                temp = temp.right;
            }
        }

        return list;
    }
}
