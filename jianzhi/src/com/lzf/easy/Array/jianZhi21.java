package com.lzf.easy.Array;

import java.util.Arrays;

public class jianZhi21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 4, 3})));
    }

    public static int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) i++;
            while (i < j && nums[j] % 2 == 0) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;

    }
}
