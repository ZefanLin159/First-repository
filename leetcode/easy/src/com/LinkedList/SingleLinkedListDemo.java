package com.LinkedList;

public class SingleLinkedListDemo {
}

class SingleLinkedLink{
    private final SingleNode head = new SingleNode(0);

    public void addData(SingleNode newNode){
        SingleNode temp = head;

    }

    public void list(){

    }
}

class SingleNode{
    int val;
    SingleNode next;

    public SingleNode() {
    }

    public SingleNode(int val, SingleNode next) {
        this.val = val;
        this.next = next;
    }

    public SingleNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}