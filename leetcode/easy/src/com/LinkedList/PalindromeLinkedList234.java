package com.LinkedList;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean flag = true;

        ListNode fast = head;
        ListNode slow = head;
        //快慢针找中间结点
        //此处注意终止条件是 只要没到尾部结点就循环
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = slow.next;
//        ListNode secHead = dummy.next;
//        ListNode newSecHead = dummy;

        //找到中间结点后，找到后半段的链表进行反转链表
        ListNode secHead = slow.next;
        ListNode newSecHead = new ListNode(0); //增加一个头结点便于secHead链表的操作
        //反转链表的操作，尾插法
        while (secHead != null) {
            ListNode next = secHead.next;
            secHead.next = newSecHead.next;
            newSecHead.next = secHead;
            secHead = next;
        }
        newSecHead = newSecHead.next;//位移到需要的链表
        //两条链表，其中有一个为空时则退出循环
        while (head != null && newSecHead != null) {
            if (head.val != newSecHead.val) {
                flag = false;
                break;
            }
            head = head.next;
            newSecHead = newSecHead.next;

        }

        return flag;
    }
    public static void main(String[] args) {

    }
}
