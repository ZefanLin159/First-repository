package com.myLinkedList;

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        newHead.next = l1 == null ? l2 : l1;//此处要注意是newHead.next指向非空的l1,l2结点
        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
