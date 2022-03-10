package com.lzf.easy;

import com.lzf.ListNode;

public class jianzhi18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode temp = newHead;

        while (temp != null) {
            if (temp.next!=null&&temp.next.val == val){
                ListNode next = temp.next;
                temp.next = next.next;
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}
