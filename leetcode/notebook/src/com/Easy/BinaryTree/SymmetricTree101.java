package com.Easy.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return inOrderTraversal(root, root);
    }

    //Recursive
    public boolean inOrderTraversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        if (inOrderTraversal(p.left, q.right) == false) return false;

        if (inOrderTraversal(p.right, q.left)) return false;

        return true;
    }

    //DFS 深度优先搜索，参考中序遍历
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        TreeNode tempLeft = root;
        TreeNode tempRight = root;

        while (tempLeft != null || tempRight != null || !stackLeft.isEmpty() || !stackRight.isEmpty()) {
            if (tempLeft != null) {
                stackLeft.push(tempLeft);
                tempLeft = tempLeft.left;
            }
            if (tempRight != null) {
                stackRight.push(tempRight);
                tempRight = tempRight.right;
            }
            //关键判断,判断堆栈的尺寸是否一致
            if (stackLeft.size() != stackRight.size()) {
                return false;
            }
            if (tempLeft == null && tempRight == null) {
                tempLeft = stackLeft.pop();
                tempRight = stackRight.pop();
                if (tempLeft.val != tempRight.val) {
                    return false;
                }
                tempLeft = tempLeft.right;
                tempRight = tempRight.left;
            }
        }
        return true;
    }

    //BFS 广度优先搜索，参考层序遍历，看题解的自己敲的
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queueLeft = new LinkedList<>();//可变队列,LinkedList可以实现Collection接口
        Queue<TreeNode> queueRight = new LinkedList<>();

        queueLeft.offer(root.left);
        queueRight.offer(root.right);
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            TreeNode tempLeft = queueLeft.poll();
            TreeNode tempRight = queueRight.poll();
            if (tempLeft == null && tempRight != null) return false;
            if (tempRight == null && tempLeft != null) return false;
            if (tempLeft != null && tempRight != null) {
                if (tempLeft.val != tempRight.val) return false;
                queueLeft.offer(tempLeft.left);//左半边先加入左子树再加入右子树
                queueLeft.offer(tempLeft.right);
                queueRight.offer(tempRight.right);//右半边要先加入右子树再加入左子树
                queueRight.offer(tempRight.left);
            }
        }

        return true;

    }


}
