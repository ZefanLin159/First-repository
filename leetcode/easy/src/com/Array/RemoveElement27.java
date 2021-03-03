package com.Array;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        //快慢针思想（ps：想不到）
        int fast = 0;
        int slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}

