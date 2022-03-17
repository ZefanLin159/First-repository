package com.lzf.easy;

import com.lzf.ListNode;

public class jianzhi22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode newHead = new ListNode();
        ListNode temp1 = head;
        ListNode temp2 = head;
        int count = 0;
        for (; temp2 != null; temp2 = temp2.next) {
            count++;
        }
        for (int i = 0; i < count - k; i++) {
            temp1 = temp1.next;
        }
        head = temp1;

        return head;

    }
}
