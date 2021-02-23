package com.algorithm.singleLinkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "lzf");
        Node node2 = new Node(2, "lzg");
        Node node3 = new Node(3, "cjx");
        Node node4 = new Node(4, "lxk");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);

        singleLinkedList.list();
    }
}

class Node {
    int num;

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    String name;
    Node next;

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
        Node tempNode = head;
        //尾插法
        while (true){
            if(tempNode.next ==null){
                break;
            }
            tempNode = tempNode.next;
        }
        tempNode.next =newNode;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("list is empty");
        } else {
            for (Node tempNode = head.next; tempNode != null; tempNode = tempNode.next) {
                System.out.println(tempNode);
            }
        }
    }

}