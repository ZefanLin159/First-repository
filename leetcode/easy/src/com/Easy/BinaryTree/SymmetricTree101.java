package com.Easy.BinaryTree;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return inOrderTraversal(root, root);
    }

    public boolean inOrderTraversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        if (inOrderTraversal(p.left, q.right) == false) return false;

        if (inOrderTraversal(p.right, q.left)) return false;

        return true;
    }
}
