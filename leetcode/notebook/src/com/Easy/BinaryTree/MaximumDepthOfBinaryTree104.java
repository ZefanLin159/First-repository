package com.Easy.BinaryTree;

import java.util.*;

public class MaximumDepthOfBinaryTree104 {
    //递归，DFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //如果不加1的话会出现输出全为0的情况，就是要加上根节点的深度
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //层序遍历，BFS
    public int maxDepth_1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = new TreeNode();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            level++;
        }
        return level;
    }

}
