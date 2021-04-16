package com.Sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class QuickSortDemo {

    public static void main(String[] args) {
        int[] n1 = {3, 4, 3, 2, 9, 10, 5, 1};
        QuickSort(n1, n1.length);
        System.out.println(Arrays.toString(n1));
    }

    /**
     * @param nums  数组
     * @param left  数组的最左边下标
     * @param right 数组的最右边下标
     * @return nums[right-1] 作为pivot(划分主元）
     */

    public static int Median3(int[] nums, int left, int right) {
        int center = (left + right) / 2;
        if (nums[left] > nums[center]) {
            int temp = nums[center];
            nums[center] = nums[left];
            nums[left] = temp;
        }
        if (nums[left] > nums[right]) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        if (nums[center] > nums[right]) {
            int temp = nums[right];
            nums[right] = nums[center];
            nums[center] = temp;
        }
        //nums[right]一定比nums[center]大，所以放在最右边后面再处理即可
        int temp = nums[right - 1];
        nums[right - 1] = nums[center];
        nums[center] = temp;
        return nums[right - 1];
    }

    /**
     * @param nums   数组
     * @param length 数组长度
     */
    public static void QuickSort(int[] nums, int length) {
        QuickSortRecursion(nums, 0, length - 1);
    }
    //快排适用于长度较大的数组

    /**
     * @param nums  传入数组
     * @param left  数组第一个下标
     * @param right 数组最后一个下标
     *              left 和 right 都是为了递归调用才设置的
     */

    public static void QuickSortRecursion(int[] nums, int left, int right) {
        //这里的cutoff = 0,其实如果按照陈越姥姥的思路，cutoff = 100最好
        //如果不加插入排序的话会有问题，暂时不知道问题出在哪
        //else 里面 用插入排序即可
        if (right - left > 0) {
            int pivot = Median3(nums, left, right);
            int i = left;
            int j = right - 1;
            for (; ; ) {
                while (nums[++i] < pivot) {
                }
                while (nums[--j] > pivot) {
                }
                if (i < j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                } else {
                    break;
                }
            }
            //将nums[i]作为主元来进行处理
            int temp = nums[i];
            nums[i] = nums[right - 1];
            nums[right - 1] = temp;
            //这里的终点为什么是i-1，起点为什么是i+1；因为主元是放在i的位置上，所以不需要到i
            //i左边砍一刀，i右边砍一刀
            QuickSortRecursion(nums, left, i - 1);
            QuickSortRecursion(nums, i + 1, right);
        } else {
            MySort.InsertSort(nums, nums.length);
        }
    }


}

