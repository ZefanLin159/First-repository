package com.Sort;

import java.util.Arrays;

public class OrderedSubColumns {

    public static void main(String[] args) {
        int[] num1 = {3, 2, 48, 8, 2, 20, 19};
        //这里输入要注意，rEnd是线性表中最后一个元素的下标
        //加了static关键字就可以不新建一个对象了？这里还需深入理
//        merge(num2, 0, 1, num2.length-1);
//        System.out.println(Arrays.toString(num2));
        MergeSort(num1, 0, num1.length - 1);
        System.out.println(Arrays.toString(num1));
    }

    public static void MergeSort(int[] num1, int lStart, int rEnd) {
        //这里一定要注意，有个小技巧，我们可以用数组长度为2的进行测试
        int lEnd = (lStart + rEnd) / 2;//用这个式子的话求出来必然是子序列左端的下标，所以切记
        int rStart = lEnd + 1;
        if (lStart < rEnd) {
            //递归的思想很简单，我们只需要在第一层一分为二，然后进行递归调用
            //分到不可分之后，再用merge函数，剩下的处理交给电脑，难点在于结束条件的思考
            MergeSort(num1, lStart, lEnd);
            MergeSort(num1, rStart, rEnd);
            //
            merge(num1, lStart, lEnd, rEnd);
        }
    }

    /**
     * @param num1   传入的数组
     * @param lStart 左端的起始位置
     * @param lEnd   左端的结束位置
     * @param rEnd   右端的结束位置
     */
    public static void merge(int[] num1, int lStart, int lEnd, int rEnd) {
        //记录元素长度，后面会有用
        int numElement = rEnd - lStart + 1;
        //这里还是申请O(N)的空间复杂度
        int[] newNum = new int[num1.length];
        int rStart = lEnd + 1;
        int i = 0;
        while (lStart <= lEnd && rStart <= rEnd) {
            if (num1[lStart] <= num1[rStart]) {
                newNum[i++] = num1[lStart++];
            } else {
                newNum[i++] = num1[rStart++];
            }
        }
        while (lStart <= lEnd) {
            newNum[i++] = num1[lStart++];
        }
        while (rStart <= rEnd) {
            newNum[i++] = num1[rStart++];
        }
        //这里的技巧在于由于lStart已经找不到，我们可以最右的下标（指针）进行移动来对排序后的数组进行赋值
        for (int k = numElement - 1; k >= 0; k--, rEnd--) {
            //和陈越姥姥的算法对比这里有一些不同，我的newNum长度是固定的
            //rEnd正是当前元素的位置，而newNum用分而治之的方法以后，只会以子序列的长度存放元素
            //初始      num1=3 2 9 8 2 6 10
            //第一组递归后num1=2 3 8 9 2 6 10
            //而此时newNum =  8 9 0 0 0 0 0
            //所以这里嵌套用倒序写法，右边下标用k，左边下标正是num1的下标。
            num1[rEnd] = newNum[k];
        }

    }
}
