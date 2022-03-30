package com.lzf.easy.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class jianZhi61 {
    public static void main(String[] args) {
        jianZhi61 jianZhi61 = new jianZhi61();
        System.out.println(jianZhi61.isStraight(new int[]{0, 0,2, 2, 6}));
    }

//    //        方法一,Set表
//    public boolean isStraight(int[] nums) {
//        int slow = 0, fast = 1;
//        Set<Integer> repeat = new HashSet<>();
//        int max = 0, min = 14;
//        for (int num : nums) {
//            if (num == 0) continue;
//            max = Math.max(max, num);
//            min = Math.min(min, num);
//            if (repeat.contains(num)) return false;
//            repeat.add(num);
//
//        }
//        return max - min < 5;
//
//    }

    //方法二,排序法
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) joker++;
            else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }

            }

        }
        return nums[4] - nums[joker] < 5;

    }

}
