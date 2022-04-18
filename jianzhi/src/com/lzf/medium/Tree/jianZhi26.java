package com.lzf.medium.Tree;

public class jianZhi26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        boolean subLeft = isSubStructure(A.left, B);
        boolean subRight = isSubStructure(A.right, B);
        return recur(A, B) || subLeft || subRight;
    }

    private boolean recur(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) return true;
        if (rootA == null || rootA.val != rootB.val) return false;
        boolean left = recur(rootA.left, rootB.left);
        boolean right = recur(rootA.right, rootB.right);
        return left && right;
    }
}

