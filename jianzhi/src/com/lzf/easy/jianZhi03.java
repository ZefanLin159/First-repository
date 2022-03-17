package com.lzf.easy;

import java.util.HashMap;

public class jianZhi03 {
        public static void main(String[] args) {
            System.out.println("Hello World");
        }

        public int findRepeatNumber(int[] nums) {

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int j = 1;
            map.put(nums[0], 0);
            for (j = 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    return nums[j];
                } else {
                    map.put(nums[j], j);
                }
            }
            return -1;

        }
    }


