package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102AndZigzagLevelTraversal103 {
    public static void main(String[] args) {
        //测试样例，勿删
        TreeNode head = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        head.left = node;
        TreeNode node1 = new TreeNode(3);
        head.right = node1;
        TreeNode node2 = new TreeNode(4);
        head.left.left = node2;
        TreeNode node3 = new TreeNode(5);
        head.left.right = node3;
        TreeNode node4 = new TreeNode(6);
        head.right.left = node4;
        TreeNode node5 = new TreeNode(7);
        head.right.right = node5;
        List<List<Integer>> test = zigzagLevelOrder(head);
        System.out.println(test);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();//更新当前层队列的尺寸
            List<Integer> list1 = new ArrayList<>();
            while (count-- > 0) {
                temp = queue.poll();
                list1.add(temp.val);//加入当前层的元素
                if (temp.left != null) {
                    queue.offer(temp.left);//加入当前层的左子树
                }
                if (temp.right != null) {
                    queue.add(temp.right);//加入当前层的右子树
                }

            }
            list.add(list1);//将遍历完的本层数据加入

        }
        return list;
    }


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
