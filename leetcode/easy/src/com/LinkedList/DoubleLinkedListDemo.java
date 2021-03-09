package com.LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleNode newNode = new DoubleNode(1);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addData(newNode);
//        System.out.println(doubleLinkedList);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private DoubleNode head = new DoubleNode(0, null, null);

    public boolean isEmpty() {
        boolean isEmptyFlag = true;
        if (head.next != null) {
            isEmptyFlag = false;
        }
        return isEmptyFlag;
    }

    public void addData(DoubleNode newNode) {
        DoubleNode temp = head;
        if (head.next == null) {
            temp.next = newNode;
            temp = temp.next;
            temp.next = null;
            temp.pre = null;
        } else {
          while (temp.next != null) {
              temp  = temp.next;
          }
          temp.next = newNode;
          temp.next.pre = temp;
        }
    }



    public void list() {
        for (DoubleNode p = head.next; p != null; p = p.next) {
            System.out.println(p);
        }
    }

}


class DoubleNode {
    int val;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode(int val, DoubleNode pre, DoubleNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public DoubleNode(int val) {
        this.val = val;
    }

    public DoubleNode() {
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "val=" + val +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}