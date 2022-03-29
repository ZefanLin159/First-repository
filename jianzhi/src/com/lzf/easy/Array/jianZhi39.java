package com.lzf.easy.Array;

import java.util.HashMap;

public class jianZhi39 {

    //    本题有三种解法，投票法、哈希表法
    public static int majorityElement1(int[] nums) {
        int half = nums.length / 2 + 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
//        keySet是总键数
        for (Integer key : map.keySet()) {
            if (map.get(key) == half) {
                return key;
            }
        }
        return -1;
    }

    public static int majorityElement(int[] nums) {
        int votes = 0, value = 0;
        for (int num : nums) {
//            从第一种情况开始分析
            if (votes == 0) value = num;
            votes += value == num ? 1 : -1;
        }
        return value;
    }
}
