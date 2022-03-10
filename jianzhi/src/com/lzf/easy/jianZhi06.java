package com.lzf.easy;

import com.lzf.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class jianZhi06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        ListNode node = new ListNode(2);
        temp.next = node;
        temp = temp.next;
        node = new ListNode(3);
        temp.next = node;
        temp = temp.next;
        node = new ListNode(4);
        temp.next = node;
        temp = temp.next;
//        reversePrint(head);
    }

//    public static int[] reversePrint(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
//
//        for (ListNode temp = head; temp != null; temp = temp.next) {
//
//        }
//
//    }

}
