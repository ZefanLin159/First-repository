package com.LinkedList;

public class RemoveLinkedListElements203 {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution203 {
//    public ListNode removeElements(ListNode head, int val) {
//        if(head == null) return null;
//        ListNode l1 = new ListNode(0);
//        ListNode temp = l1;
//        while (head!=null){
//            temp.next = head;
//            if(head.val == val ){
//                if(head.next!=null){
//                    head = head.next.next;
//                }else {
//                    head = null;
//                }
//            }else {
//                head = head.next;
//            }
//
//            temp = temp.next;
//        }
//
//        return l1.next;
//
//    }
//}

//考虑[1,1,1] 1的情况怎么解决
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode newHead = dummyHead;
        while (newHead.next != null) {
            ListNode next = newHead.next;
            if (next.val == val) {    //注意该判断条件要用新的next结点来判断
                newHead.next = next.next;
            } else {
                newHead = newHead.next;
            }
        }
        return dummyHead.next;
    }
}
