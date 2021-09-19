package com.Medium.myArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
//            nums[i] != nums[i - 1] 这句话是和前面的元素对比
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        //asList 返回一个以List<Attribute>返回此列表的List<Attribute> 。 对原始AttributeList的更改反映了对返回值的更改，反之亦然。
//                        res.add(Arrays.asList(nums[lo],nums[hi],nums[i]));
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[lo]);
                        list.add(nums[hi]);
                        res.add(list);
//                        当前元素已经填入列表，低位所以要和后面的元素比较，如果元素相同则要右移指针
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] > sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }

        return res;
    }
}
