package com.lzf.medium.Tree;

import java.util.LinkedList;
import java.util.List;

public class jianZhi34 {
    LinkedList<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return list;
    }

    private void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
//          这里要注意，一定要new一个新对象
            list.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
//        路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.removeLast()
        path.removeLast();


    }
}


