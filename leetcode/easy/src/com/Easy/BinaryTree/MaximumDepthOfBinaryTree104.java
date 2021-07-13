package com.Easy.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //如果不加1的话会出现输出全为0的情况，就是要加上根节点的深度
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

   
}
