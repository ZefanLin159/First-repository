package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi55_1 {
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
//        这个加1是因为递归最后会返回0，所以返回的时候要+1（感觉做递归要先定好退出条件和返回条件），一层一层往上加
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
