package com.Medium.myLinkList;

public class SwapNodesInPairs24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp =dummy;
        while (temp.next !=null && temp.next.next!=null){
            ListNode swap1 = temp.next;
            ListNode swap2 = temp.next.next;
            temp.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            temp = swap1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        ListNode node = new ListNode(2);
        temp.next = node;
        temp = temp.next;
        node = new ListNode(3);
        temp.next = node;
        temp = temp.next;
        node = new ListNode(4);
        temp.next = node;
        temp = temp.next;
        swapPairs(head);

    }

}
