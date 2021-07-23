package com.Easy.myLinkedList;

public class AddTwoNumbers02 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode temp = l3;
        int plus = 0;

        while(l1!=null && l2!=null){
            ListNode newL = new ListNode();
            newL.val = l1.val+l2.val+plus;
            if(newL.val>=10){
                newL.val %= 10;
                plus = 1;
            }else{
                plus = 0;
            }
            temp.next = newL;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //noinspection DuplicatedCode
        while(l1!=null){
            l1.val += plus;
            if(l1.val>=10){
                l1.val%=10;
                plus = 1;
            }else{
                plus = 0;
            }
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        //noinspection DuplicatedCode
        while(l2!=null){
            l2.val += plus;
            if(l2.val>=10){
                l2.val%=10;
                plus = 1;
            }else{
                plus = 0;
            }
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        if(plus == 1){
            temp.next = new ListNode(1);
        }

        return l3.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        int sum = 0;
        int sumFlag = 0;
        while(l1 != null || l2!=null || sumFlag >0){
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 :l2.val) + sumFlag;
            sumFlag = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return l3.next;
    }
}
