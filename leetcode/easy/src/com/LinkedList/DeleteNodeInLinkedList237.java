package com.LinkedList;

public class DeleteNodeInLinkedList237 {
    public static void main(String[] args) {

    }
}
class Solution237{
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}