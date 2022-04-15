package com.lzf.medium.myLinkList;



public class jianZhi35 {
    Node head;

    public Node copyRandomList(Node head) {
        this.head = head;
        cloneNodes(head);
        connectRandomNode(head);
        return reconnectNode(head);
    }

    public void cloneNodes(Node head) {
        Node pNode = head;
        while (pNode != null) {
            Node pCLone = new Node();
            pCLone.val = pNode.val;
            pCLone.next = pNode.next;
            pCLone.random = null;
            pNode.next = pCLone;
            pNode = pCLone.next;
        }
    }

    public void connectRandomNode(Node head) {
        Node pNode = head;
        while (pNode != null) {
            Node pClone = pNode.next;
            if (pClone.random != null) {
                pClone.random = pNode.random.next;
            }
            pNode = pClone.next;
        }
    }

    public Node reconnectNode(Node head) {
        Node pNode = head;
        Node pCloneHead = null;
        Node pCloneNode = null;
        if (pNode != null) {
            pCloneHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return pCloneHead;
    }

    public class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node() {

        }

    }
}
