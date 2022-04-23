package com.lzf.hard;

public class jianZhi51 {
    public static void main(String[] args) {
        jianZhi51 jianZhi51 = new jianZhi51();
        System.out.println(jianZhi51.reversePairs(new int[]{7, 5, 6, 4}));
    }


    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int left = mergeSort(l, m);
        int right = mergeSort(m + 1, r);
        int res = left + right;
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }

}
