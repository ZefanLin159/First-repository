package com.lzf.easy.Tree;

import com.lzf.TreeNode;

import java.util.*;

public class jianZhi32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    subList.add(node.val);
                }
                if (node != null && node.left != null) queue.add(node.left);
                if (node != null && node.right != null) queue.add(node.right);

            }
            list.add(subList);
        }
        return list;
    }
}
