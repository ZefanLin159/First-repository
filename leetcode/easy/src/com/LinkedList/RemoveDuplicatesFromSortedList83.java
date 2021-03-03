package com.LinkedList;

public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp.next != null){
            //若相等则删除下一个结点，若不相等则遍历
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {

    }
}

