package com.BinaryTrees;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreesDemo {
    public static void main(String[] args) {
        //设置空树
        BinaryTrees bt = new BinaryTrees();
        BinaryTreesNode root = new BinaryTreesNode(1);
        bt.setRoot(root);
        BinaryTreesNode l1 = new BinaryTreesNode(2);
        BinaryTreesNode r1 = new BinaryTreesNode(3);
        root.setLeftNode(l1);
        root.setRightNode(r1);
        BinaryTreesNode l2 = new BinaryTreesNode(4);
        BinaryTreesNode r2 = new BinaryTreesNode(5);
        l1.setLeftNode(l2);
        l1.setRightNode(r2);
        BinaryTreesNode l3 = new BinaryTreesNode(6);
        BinaryTreesNode r3 = new BinaryTreesNode(7);
        r1.setLeftNode(l3);
        r1.setRightNode(r3);
//        bt.TreeShowRecursion();
//        bt.TreeShow();
        bt.levelOrderShow();
    }
}

class BinaryTreesNode {
    int num;
    BinaryTreesNode leftNode;
    BinaryTreesNode rightNode;

    public BinaryTreesNode(int num) {
        this.num = num;
    }

    //这是个小技巧
    public void setLeftNode(BinaryTreesNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(BinaryTreesNode rightNode) {
        this.rightNode = rightNode;
    }


    //非递归的中序遍历
    public void TreeShow(BinaryTreesNode binaryTreesNode) {
        Stack<BinaryTreesNode> stack = new Stack<>();
        BinaryTreesNode T = binaryTreesNode;
        //只要树不空或者堆栈不空就一直循环
        while (T != null || stack.empty() == false) {
            //若结点不为空，则压栈后结点指向左子树
            while (T != null) {
                stack.push(T);
                T = T.leftNode;
            }
            //若压栈不为空，则出栈一次后结点指向右子树
            if (stack.empty() == false) {
                T = stack.pop();
                System.out.println(T.num);
                T = T.rightNode;
            }
        }
    }

    //中序递归遍历
    public void TreeShowRecursion(BinaryTreesNode bt) {
        if (bt != null) {
            TreeShowRecursion(bt.leftNode);
            System.out.println(bt.num);
            TreeShowRecursion(bt.rightNode);
        }
    }

    //层序遍历
    public void levelOrderShow(BinaryTreesNode root) {
        if (root == null) return;
        //capacity是ArrayQueue队列的容量
        ArrayQueue<BinaryTreesNode> queue = new ArrayQueue<>(7);
        BinaryTreesNode T = root;
        queue.add(root);
        while (queue.isEmpty() == false) {
            //这里只能取出队列组首位 i = 0,否则会抛出异常
            T = queue.remove(0);
            System.out.println(T.num);
            //和伪码不一样，这里要判断一下加入的结点是否为空，为空则不加入
            if (T.leftNode != null) {
                queue.add(T.leftNode);
            }
            if (T.rightNode != null) {
                queue.add(T.rightNode);
            }
        }

    }
}

class BinaryTrees {
    private BinaryTreesNode root;

    public void setRoot(BinaryTreesNode root) {
        this.root = root;
    }

    //获取根结点
    public BinaryTreesNode getRoot() {
        return root;
    }

    public void TreeShow() {
        root.TreeShow(root);
    }

    public void TreeShowRecursion() {
        root.TreeShowRecursion(root);
    }

    public void levelOrderShow() {
        root.levelOrderShow(root);
    }
}