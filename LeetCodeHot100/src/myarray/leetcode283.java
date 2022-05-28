package myarray;

import java.util.Arrays;

//移动0
public class leetcode283 {
    public static void main(String[] args) {
        leetcode283 lc283 = new leetcode283();
        int[] nums = new int[]{0, 0, 3, 4, 5};
        lc283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        int i = len - 1, j = len - 1;
        for (; j >= 0; j--) {
            if (nums[j] == 0) {
                for (int k = j + 1; k <= i; k++) {
                    nums[k - 1] = nums[k];
                }
                nums[i] = 0;
                i--;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (int k = i;k<nums.length;k++){
            nums[k] = 0;
        }
    }

}
