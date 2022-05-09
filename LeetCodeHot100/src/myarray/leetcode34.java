package myarray;

import java.util.Arrays;

public class leetcode34 {
    public static void main(String[] args) {
        leetcode34 leetcode34 = new leetcode34();
        System.out.println(Arrays.toString(leetcode34.searchRange(new int[]{1}, 0)));

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int val1 = right;
        if (val1 <0 || nums[val1] != target) return new int[]{-1, -1};
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int val2 = left;
        return new int[]{val2, val1};
    }
}
