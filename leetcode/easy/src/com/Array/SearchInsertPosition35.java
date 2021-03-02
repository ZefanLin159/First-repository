package com.Array;

public class SearchInsertPosition35 {
    public static void main(String[] args) {

    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        boolean isDuplicate = false;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate == false) {
            for (i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }
            }
            //这里遍历完的i已经是数组的长度了，记住for循环的顺序
        }
        return i;
    }
}