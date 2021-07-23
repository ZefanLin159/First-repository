package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelTraversal103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = new TreeNode();
        queue.offer(root);
        boolean isEven = false;
        while (!queue.isEmpty()) {
            int count = queue.size();

            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                temp = queue.poll();
//                看的题解，增加了标志位，但是有一处bug一直无法解决,应该处理可变数组的添加顺序而不是处理队列的添加顺序
                if (isEven) {
                    list.add(0, temp.val);
                } else list.add(temp.val);

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }

            res.add(list);
            isEven = !isEven;
        }

        return res;
    }
}
