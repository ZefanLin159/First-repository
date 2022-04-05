package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;//找到祖先，返回
        TreeNode left = lowestCommonAncestor(root.left, p, q); //递归左子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);//递归右子树
        if (left == null && right == null) return null; //都为空可以提前返回空
        if (left == null) return right; //左树不存在，返回右节点
        if (right == null) return left; //右树不存在，返回左节点
        return root;
    }
}
