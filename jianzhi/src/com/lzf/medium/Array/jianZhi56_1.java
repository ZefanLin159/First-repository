package com.lzf.medium.Array;

import java.util.Arrays;

public class jianZhi56_1 {

    public static void main(String[] args) {
        jianZhi56_1 jianZhi56_1 = new jianZhi56_1();
        System.out.println(Arrays.toString(jianZhi56_1.singleNumbers(new int[]{1, 1, 3, 3, 4, 2})));
    }

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums)               // 1. 遍历异或
            n ^= num;
        while ((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for (int num : nums) {              // 3. 遍历 nums 分组
            if ((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[]{x, y};          // 5. 返回出现一次的数字
    }

}
