package com.lzf.easy;


import com.lzf.TreeNode;

public class jianzhi28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return SymmetricCheck(root.left, root.right);

    }

    private boolean SymmetricCheck(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        } else {
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                } else {
                    return SymmetricCheck(left.left, right.left) && SymmetricCheck(left.right, right.right);
                }
            }
        }
        return true;
    }
}
