package com.lzf.medium.Array;

public class jianZhi56_2 {
    public static void main(String[] args) {
        jianZhi56_2 jianZhi56_2 = new jianZhi56_2();
        System.out.println(jianZhi56_2.singleNumber(new int[]{3, 4, 3, 3}));

    }

    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }


}
