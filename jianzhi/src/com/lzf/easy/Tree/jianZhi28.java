package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricCheck(root.left, root.right);
    }

    public boolean isSymmetricCheck(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetricCheck(left.left, right.right) && isSymmetricCheck(left.right, right.left);
    }
}
