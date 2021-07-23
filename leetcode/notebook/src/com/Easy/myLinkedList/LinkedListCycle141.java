package com.Easy.myLinkedList;

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //快慢针解法
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        return fast != null && fast.next != null;
    }
    public static void main(String[] args) {

    }
}