package com.lzf.medium.Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class jianZhi32_1 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


        TreeNode head = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        head.left = node;
        TreeNode node1 = new TreeNode(3);
        head.right = node1;
        TreeNode node2 = new TreeNode(4);
        head.left.left = node2;
        TreeNode node3 = new TreeNode(5);
        head.left.right = node3;
//        TreeNode node4 = new TreeNode(15);
//        head.right.left = node4;
//        TreeNode node5 = new TreeNode(7);
//        head.right.right = node5;
        jianZhi32_1 jianZhi32_1 = new jianZhi32_1();
        System.out.println(jianZhi32_1.levelOrder(head));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

}

