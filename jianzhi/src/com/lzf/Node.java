package com.lzf;

//jianZhi35 Node
//public class Node {
//    public int val;
//    public Node next;
//    public Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//
//    public Node() {
//
//    }
//
//}

//jianZhi36 Node
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};