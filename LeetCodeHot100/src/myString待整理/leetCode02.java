package myString待整理;

public class leetCode02 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        leetCode02 lc02 = new leetCode02();
        System.out.println(lc02.addTwoNumbers(l1, l2));
    }

    //        本题还是创建节点较容易
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode();
            node.val = l1.val + l2.val + flag;
            if (node.val >= 10) {
                node.val %= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            temp.next = node;
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }

        while (l1 != null) {
            l1.val += flag;
            if (l1.val == 10) {
                l1.val = 0;
                flag = 1;
            } else {
                flag = 0;
            }
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            l2.val += flag;
            if (l2.val == 10) {
                l2.val = 0;
                flag = 1;
            } else {
                flag = 0;
            }

            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        if (flag == 1) {
            temp.next = new ListNode(1);
        }
        return newHead.next;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = carry + x + y > 0 ? 1 : 0;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
}


