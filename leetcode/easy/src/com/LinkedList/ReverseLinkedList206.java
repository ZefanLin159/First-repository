package com.LinkedList;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        //反转链表，也是尾插法
        while (head != null){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

    }
}

