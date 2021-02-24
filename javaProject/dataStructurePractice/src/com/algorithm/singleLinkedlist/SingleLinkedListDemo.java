package com.algorithm.singleLinkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "lzg");
        Node node2 = new Node(2,"lzf");

        SingleLinkedList singleLinkedList =  new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.list();

    }
}

class Node {
    int num;
    String name;

    Node next;

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}

class SingleLinkedList {
    private final Node head = new Node(0, "");

    public void add(Node newNode) {
        Node temp = head;

        if (temp.next != null) {
            while (temp.next != null) {
                temp = temp.next;
            }

        }
        temp.next = newNode;
    }

    public void list() {
        for (Node p = head.next; p != null; p = p.next) {
            System.out.println(p);
        }
    }
}