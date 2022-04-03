package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi54 {
    public static void main(String[] args) {

        TreeNode head = new TreeNode(3);
        TreeNode node = new TreeNode(1);
        head.left = node;
        TreeNode node1 = new TreeNode(4);
        head.right = node1;
//        TreeNode node2 = new TreeNode(4);
//        head.left.left = node2;
//        TreeNode node3 = new TreeNode(2);
//        head.left.right = node3;
//        TreeNode node4 = new TreeNode(6);
//        head.right.left = node4;
//        TreeNode node5 = new TreeNode(7);
//        head.right.right = node5;
        jianZhi54 jianZhi54 = new jianZhi54();
        jianZhi54.kthLargest(head, 2);
    }

    //    本题重点是要定义类变量，才能保证返回的值
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k; //类变量赋值
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }


}
