package com.Array;

public class PlusOne66 {
    public int[] plusOne1(int[] digits) {
        //迭代的方法
        //倒序遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            //未发生进位，则直接加1后退出循环
            if (digits[i] < 9) {
                digits[i] += 1;
                break;
            }
            //若发生进位，则还要进行循环
            digits[i] = 0;
        }
        //如果最高位变成了0，则需要扩张数组
        if (digits[0] == 0) {
            int[] ans = new int[digits.length + 1];//这里默认隐藏最低位为0
            ans[0] = 1;
            digits = ans;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9};
//        PlusOne66 plusOne66 = new PlusOne66();
//        System.out.println(plusOne66.plusOne1(digits));
    }
}


//class Solution66 {
//    public int[] plusOne(int[] digits) {
//[9,9] 无法考虑99的情况
//       int[] nums =new int[digits.length+1];
//       int i = 0 ;
//       for(i = 0;i<digits.length-1;i++);
//       if(digits[i] == 9){
//           nums[i] = 1;
//           nums[i+1] = 0;
//           for(int j = 0 ; j<digits.length-1;j++){
//               digits[j] = nums[j];
//           }
//           return nums;
//       }else {
//           digits[i] += 1;
//       }
//       return  digits;

//    }
//}