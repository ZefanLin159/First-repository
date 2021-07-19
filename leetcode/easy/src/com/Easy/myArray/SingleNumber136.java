package com.Easy.myArray;

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int sigNum = 0;
        for(int i = 0;i<nums.length;i++){
          sigNum^=nums[i];
        }
        return sigNum;
    }
}
