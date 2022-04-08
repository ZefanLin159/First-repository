package com.lzf.medium.Array;

import java.util.Arrays;

public class jianZhi56_1 {

    public static void main(String[] args) {
        jianZhi56_1 jianZhi56_1 = new jianZhi56_1();
        System.out.println(Arrays.toString(jianZhi56_1.singleNumbers(new int[]{1, 1, 3, 3, 4, 2})));
    }

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            n ^= num;
        }
//        可 获取整数 x⊕y 首位 1
        while ((n & m) == 0) {
            m = m << 1;
        }
        for (int num : nums) {
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};          // 5. 返回出现一次的数字
    }

}
