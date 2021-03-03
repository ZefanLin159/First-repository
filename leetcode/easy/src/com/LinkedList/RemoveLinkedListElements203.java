package com.LinkedList;

public class RemoveLinkedListElements203 {
    //考虑[1,1,1] 1的情况怎么解决
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode newHead = dummyHead;
        //建议接上新的表头便于对传入的链表头进行操作
        while (newHead.next != null) {
            ListNode next = newHead.next;
            if (next.val == val) {    //注意该判断条件要用新的next结点来判断
                newHead.next = next.next;
            } else {
                newHead = newHead.next;
            }
        }
        return dummyHead.next;//最后返回原来的链表头，这样不容易出错
    }
    public static void main(String[] args) {

    }
}

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

