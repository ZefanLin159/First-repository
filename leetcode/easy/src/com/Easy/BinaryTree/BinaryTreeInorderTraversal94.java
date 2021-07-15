package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        head.left = node;
        TreeNode node1 = new TreeNode(3);
        head.right = node1;
        TreeNode node2 = new TreeNode(4);
        head.left.left = node2;
        TreeNode node3 = new TreeNode(5);
        head.left.right = node3;
        TreeNode node4 = new TreeNode(6);
        head.right.left = node4;
        TreeNode node5 = new TreeNode(7);
        head.right.right = node5;
    }

    //中序遍历递归
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

    //中序遍历迭代
    public List<Integer> inorderTraversal94_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
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





}
