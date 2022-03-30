package com.lzf.easy.Array;

public class jianZhi53_2 {
    public static void main(String[] args) {
        jianZhi53_2 jianZhi53_2 = new jianZhi53_2();
//        System.out.println(jianZhi53_2.missingNumber(new int[]{0, 1, 3}));
        System.out.println(jianZhi53_2.missingNumber(new int[]{1}));
//        System.out.println(jianZhi53_2.missingNumber(new int[]{0, 1, 3}));
//        System.out.println(jianZhi53_2.missingNumber(new int[]{0, 1, 3}));
    }

    public int missingNumber1(int[] nums) {
//        先用O(n)的方法
        int slow = 0, fast = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
//        唯一值问题，无脑等号，并且l = m+1,r = m-1,最后返回m
        int left = 0, right = nums.length - 1, middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (middle == nums[middle]) left = middle + 1;
            else right = middle - 1;
        }
////        等号：退出时左指针会大于右指针
//        return middle;
//        本题比较特殊，这里要返回left，或者排除极端情况[0],[1],[0,1]
        if(nums.length == 1 && nums[0] == 0) return 1;
        if(nums.length == 1 && nums[0] == 1) return 0;
        if(nums.length == 2 && nums[0] == 0 && nums[1] == 1) return 2;
        return middle;
    }
}
