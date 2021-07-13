package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal94And144And145 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal94(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursiveInorder(root, list);
        return list;
    }

    public void recursiveInorder(TreeNode p, List<Integer> list) {   //这里递归返回空值就行，因为已经有list的了
        if (p == null) return;
        recursiveInorder(p.left, list);
        list.add(p.val);
        recursiveInorder(p.right, list);
    }

    public List<Integer> inorderTraversal94_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        while (temp != null || stack.isEmpty() == false) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal144(TreeNode root) {
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

    public List<Integer> postorderTraversal145(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null && !stack.isEmpty()) {
            if (temp != null) {

            } else {

            }
        }

        return list;
    }

}
