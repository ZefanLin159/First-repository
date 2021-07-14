package com.Easy.BinaryTree;

import java.util.Stack;

public class SameTree100 {
    public static void main(String[] args) {
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrderTraversal(p, q);
    }

    public boolean inOrderTraversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (!inOrderTraversal(p.left, q.left)) return false;

        if (p.val != q.val) {
            return false;
        }

        if (!inOrderTraversal(p.right, q.right)) return false;

        return true;
    }
}
