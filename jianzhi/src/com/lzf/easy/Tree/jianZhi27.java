package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }
}
