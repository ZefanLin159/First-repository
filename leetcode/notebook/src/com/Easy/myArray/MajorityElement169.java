package com.Easy.myArray;

import java.util.HashMap;
import java.util.List;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 1, 2};
        System.out.println(majorityElement_2(nums));


    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0);//如果此时键值对应的元素为空，则得到默认值。
            if(count == nums.length/2){
                val = nums[i];
                break;
            }
            map.put(nums[i],count+1);
        }
        return val;
    }

    public static int majorityElement_2(int[] nums) {
      int count = 1;
      int group = nums[0];
      for(int i = 1;i<nums.length;i++){
          if(count == 0){
              //记录同归于尽后的新组 比如[2,2,1,1，   2,2,1]，第3个2就是新队伍，如果不死(count !=0)就一直保留
              count = 1;//这里要重新计数，切记(自己写的时候漏了）。
              group = nums[i];
              continue;
          }
          if(group == nums[i]){
              count+=1;
          }else {
              count-=1;
          }

      }
      return group;
    }

}
