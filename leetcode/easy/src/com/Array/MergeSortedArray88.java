package com.Array;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //将 nums1 的数字全部移动到末尾,这里是copy的，需要自己理解一下这个技巧
        for (int count = 1; count <= m; count++) {
            nums1[m + n - count] = nums1[m - count];
        }

        int k = 0,j = 0,i = n;//这里为什么是从n开始遍历
    }

    public static void main(String[] args) {
        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        mergeSortedArray88.merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(nums1);
    }
}

class Solution88 {
    //自己的写法，运行有问题，
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            //语法逻辑有问题
            nums1 = nums2;
            return;
        }
        if (nums2.length == 0) return;
        int[] nums3 = new int[m + n];
        nums3 = nums1;
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums3[i] = nums2[j];
        }
        for (int i = 0; i < m + n; i++) {
            for (int j = 0; j < m + n; j++) {
                if (nums3[i] >= nums3[j]) {
                    int temp = nums3[i];
                    nums3[j] = nums3[i];
                    nums3[i] = temp;
                }
            }
        }
        //语法逻辑有问题
        nums1 = nums3;

    }
}