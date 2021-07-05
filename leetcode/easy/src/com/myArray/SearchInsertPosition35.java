package com.myArray;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        boolean isDuplicate = false;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate == false) {
            for (i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }
            }
            //这里遍历完的i已经是数组的长度了，记住for循环的顺序
        }
        return i;
    }

    public int searchInsert1(int[] nums, int target) {
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(i+1 != nums.length){
                if(target>nums[i] && target <=nums[i+1]){
                    index = i+1;
                    break;
                }
            }else{
                //这里要注意分两种情况，一种是等于的索引，一种是大于的索引
                if(target ==nums[i]){
                    index = i;
                }else if(target > nums[i]){
                    index = i+1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {

    }
}
