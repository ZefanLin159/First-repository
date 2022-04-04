package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi55_2 {

    public static void main(String[] args) {


        TreeNode head = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        head.left = node;
//        TreeNode node1 = new TreeNode(20);
//        head.right = node1;
        TreeNode node2 = new TreeNode(3);
        head.left.left = node2;
        TreeNode node3 = new TreeNode(3);
        head.left.right = node3;
//        TreeNode node4 = new TreeNode(15);
//        head.right.left = node4;
//        TreeNode node5 = new TreeNode(7);
//        head.right.right = node5;
        jianZhi55_2 jz55_2 = new jianZhi55_2();
        System.out.println(jz55_2.isBalanced(head));
    }

    public boolean isBalanced(TreeNode root) {
        int isBalanceFlag = dfs(root);
        return isBalanceFlag != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs((root.right));
        if (right == -1) return -1;
        return Math.abs(right - left) < 2 ? Math.max(left, right) + 1 : -1;
    }



}
