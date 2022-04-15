package com.lzf.medium.Tree;

import java.util.*;

public class jianZhi32_3 {
    public static class TreeNode {
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
//        TreeNode node3 = new TreeNode(5);
//        head.left.right = node3;
//        TreeNode node4 = new TreeNode(15);
//        head.right.left = node4;
        TreeNode node5 = new TreeNode(5);
        head.right.right = node5;

        jianZhi32_3 jianZhi32_3 = new jianZhi32_3();
        System.out.println(jianZhi32_3.levelOrder(head));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        boolean level = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            if (!level) Collections.reverse(subList);
            list.add(subList);
            level = !level;
        }

        return list;
    }
}

