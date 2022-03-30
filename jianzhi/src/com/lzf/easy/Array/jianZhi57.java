package com.lzf.easy.Array;

import java.util.Arrays;
import java.util.HashMap;

public class jianZhi57 {
    public static void main(String[] args) {
        jianZhi57 jianZhi57 = new jianZhi57();
        int[] sum = jianZhi57.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(sum));
    }

    //    两数之和无序hashMap(遍历两次),有序对撞针
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index1 = 0, index2 = 0;
        int temp = 0;
//        遍历一遍存放map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
//            如果键值存在并且键值对应的值不为当前索引
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{nums[i], temp};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int s = 0;
        while (i < j) {
            s = nums[i] + nums[j];
            if (target == s) {
                return new int[]{nums[i], nums[j]};
            } else if (target < s) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }
}
