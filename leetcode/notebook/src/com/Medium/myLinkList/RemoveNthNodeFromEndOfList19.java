package com.Medium.myLinkList;


public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int sum = 0;
        int count = 0;
        //自己写的，不过遍历两遍过，所以还是有待优化。
        //我这也算是快慢针

        while(temp!=null){
            sum++;
            temp = temp.next;
        }
        //这里要注意头节点的删除，如果不这样处理可能会出问题
        if(sum == n){
            ListNode newHead = new ListNode();
            newHead.next = head.next;
            return newHead.next;
        }
        temp = head;
        while(temp!=null){
            count++;
            ListNode next = temp.next;
            if(sum - count == n)
            {
                if(next !=null){
                    if(next.next != null){
                        temp.next = next.next;
                        break;
                    }else{
                        temp.next = null;
                        break;
                    }
                }else{
                    temp.next = null;
                    break;
                }
            }

            temp = temp.next;

        }
        return head;
    }

}
