package com.lzf.easy;

import com.lzf.ListNode;

public class jianzhi24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode();
        while (head!=null){
//            加一个next防止链表断裂
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return  newHead.next;
    }
}
