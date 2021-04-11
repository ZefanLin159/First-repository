package com.MyMap.Demo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {
        //HashMap同样键值，会将前面的键值对应的value覆盖掉
        //HashMap可以参考leetcode第一题
        Map<String, String> map = new HashMap<String, String>();
        map.put("001", "lqx");
        map.put("002", "zmy");
        map.put("003", "wzx");
        map.put("004", "xxx");
        map.put("003", "lsp");

//        map.clear();清除集合元素
        System.out.println(map);
        System.out.println(map.containsKey("003"));
    }

    public static int[] twoSumSolution1(int[] nums, int target) throws Exception {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int val = target - nums[j];
            //get()返回指定键映射到的值，如果此映射不包含键的映射，则返回 null
            //containValue()如果有对应的值，则返回 true
            //containsKey(Object key) 如果有对应的键值，则返回 true 。
            if (hm.containsKey(val) && hm.get(val) != j) {
                return new int[]{hm.get(val), j};
            }
        }
        throw new IllegalArgumentException("xxx");

    }
}
