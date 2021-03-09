package com.Array;

import java.util.Stack;

public class Bisection000 {
    int[] newArray = new int[]{1, 3, 5, 7, 8, 9, 10};
    Stack<Integer> stack = new Stack<Integer>();
    public int findTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int index = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else {
                if (nums[mid] > target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Bisection000 bisection000 = new Bisection000();
        System.out.println(bisection000.findTarget(bisection000.newArray,13));
    }
}
