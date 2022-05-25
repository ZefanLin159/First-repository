package MyLink;

//环形链表2
public class leetcode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            ListNode enterNode = head;
            while (enterNode != slow) {
                enterNode = enterNode.next;
                slow = slow.next;
            }
            return enterNode;

        } else {
            return null;
        }
    }
}

