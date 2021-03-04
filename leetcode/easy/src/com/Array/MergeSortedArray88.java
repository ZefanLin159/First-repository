package com.Array;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        //精妙之处依然是倒序遍历，k指向多余的空间来进行遍历
        while (j >= 0) {
            if (i < 0) {
                while (j >= 0) {
                    nums1[k] = nums2[j];//粗心了，这里应填入nums1[k]的，写成了nums2[k]
                    k--;
                    j--;
                }
                break;
            }
            //这里如果直接提交会出现j>=0时，而i<0的情况，所以需要在前面加关于i的判断语句
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;

        }
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