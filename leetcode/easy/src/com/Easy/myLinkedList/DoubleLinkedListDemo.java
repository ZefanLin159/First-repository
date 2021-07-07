package com.Easy.myLinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addData(n1);
        doubleLinkedList.addData(n2);
        doubleLinkedList.addData(n3);
        doubleLinkedList.addData(n4);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private DoubleNode head = new DoubleNode();
    private DoubleNode tail = new DoubleNode();
    int size = 0;

    public boolean isEmpty() {
        boolean flag = false;
        if (head.next == null) {
            flag = true;
        }
        return flag;
    }

    public void addData(DoubleNode newNode) {
        DoubleNode temp = head;
        if (this.isEmpty()) {
            temp.next = newNode;
            newNode.pre = null;//首个结点不指向头结点
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.pre = temp;

        }
        tail.pre = newNode;
        size++;
    }

    public void list() {
        for (DoubleNode p = head.next; p != null; p = p.next) {
            System.out.println(p.val);
        }
        for(DoubleNode p = tail.pre;p!=null;p = p.pre){
            System.out.println(p.val);
        }
    }
}

class DoubleNode {
    DoubleNode pre;
    int val;
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int val) {
        this.val = val;
    }

}
