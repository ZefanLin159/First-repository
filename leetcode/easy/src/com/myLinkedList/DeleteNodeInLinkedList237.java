package com.myLinkedList;

public class DeleteNodeInLinkedList237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {

    }
}