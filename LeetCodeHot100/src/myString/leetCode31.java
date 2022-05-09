package myString;

import java.util.Arrays;

public class leetCode31 {
    public static void main(String[] args) {
        leetCode31 lc31 = new leetCode31();
        int[] nums = new int[]{1,3,4,2};
        lc31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {reverse(nums, 0); return;}
        while (j > 0 && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);

    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
