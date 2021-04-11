package com.myArray;

import java.util.HashMap;
import java.util.Map;

public class TwoSum01 {
    //时间复杂度O(N^2),空间复杂度O(1);
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    //时间复杂度O(N),空间复杂度O(N);
    public static int[] twoSumSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            //因为要返回的是下标，所以把下标放入hashmap的value方便map.get的使用
            //如果存在键值（数）且对应的下标不和当前的下标重复
            if (map.containsKey(sub) && map.get(sub) != i) {
                //返回hashMap的value（也就是数组的下标）
                return new int[]{i, map.get(sub)};
            }

        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 1, 0};
        twoSumSolution(nums, 5);
    }


    public static int[] twoSumSolution1(int[] nums, int target) throws Exception {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int val = target - nums[j];
            //get()返回指定键映射到的值，如果此映射不包含键的映射，则返回 null
            //containValue()如果此映射将一个或多个键映射到指定值，则返回 true
            if (hm.containsKey(val) && hm.get(val) != j) {
                return new int[]{hm.get(val), j};
            }
        }
        throw new IllegalArgumentException("xxx");

    }
}
