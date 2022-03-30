package com.lzf.easy.Array;

import java.util.Arrays;

public class jianZhi40 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 643, 13, 1, 45};
        jianZhi40 jianZhi40 = new jianZhi40();
        nums = jianZhi40.getLeastNumbers(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
//        选择排序法，时间复杂度很高
        int maxValue = arr[arr.length - 1];
        int temp = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
//        return Arrays.copyOf(arr, k);
    }

    //    快排核心思路，背下来！！
    private void quickSort(int[] arr, int l, int r) {
//      1.终止条件，子数组为1
        if (l >= r) return;
//        2.定义哨兵，一般取第一个元素
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--; // 右遍历找到第一个比哨兵小的元素
            while (i < j && arr[i] <= arr[l]) i++; // 左遍历找到第一个比哨兵大的元素
//            交换这两个元素
            swap(arr, i, j);
        }
//        交换哨兵
        swap(arr, l, i); //或者swap（arr,l,j)这里i，j正好相遇
//      递归调用左右子数组（注意边界）
        quickSort(arr, l, i);
        quickSort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
