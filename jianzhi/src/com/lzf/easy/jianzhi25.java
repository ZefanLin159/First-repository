package com.lzf.easy;

import com.lzf.ListNode;

public class jianzhi25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l2 == null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return newHead.next;

    }
}
