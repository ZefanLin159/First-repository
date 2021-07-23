package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal102AndLevelOrderBottom107 {
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
        List<List<Integer>> list = levelOrderBottom(head);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;   //这个判断一定不能少
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.offer(root);
        while (!queue.isEmpty()) {//层序遍历只需要一层
            int count = queue.size();//更新当前层队列的尺寸
            List<Integer> list1 = new ArrayList<>();
            while (count-- > 0) {
                temp = queue.poll();//记得获取当前指针的头部！练习的时候忘了
                list1.add(temp.val);//加入当前层的元素
                if (temp.left != null) {
                    queue.offer(temp.left);//加入当前层的左子树
                }
                if (temp.right != null) {
                    queue.offer(temp.right);//加入当前层的右子树
                }

            }
            res.add(list1);//将遍历完的本层数据加入

        }
        return res;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        TreeNode cur = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);

            }
            res.add(0, list);
        }
        return res;
    }



}
