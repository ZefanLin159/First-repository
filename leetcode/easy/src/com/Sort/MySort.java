package com.Sort;

import java.util.Arrays;

public class MySort {
    public static void main(String[] args) {
        int[] n1 = {34, 8, 64, 51, 32, 21};
        MySort mySort = new MySort();
        n1 = mySort.SelectionSort(n1, n1.length);
//        n1 = mySort.InsertSort(n1, n1.length);
//        n1 = mySort.BubbleSort(n1, n1.length);
        System.out.println(Arrays.toString(n1));
    }

    public int[] InsertSort(int[] num1, int length) {
        int i, j;
        //i = 1默认第一张牌已经插入，必然有序
        for (i = 1; i < length; i++) {
            int temp = num1[i];//摸下一张牌
            //内层倒序遍历，并且判断条件是前面牌大于寄存器的牌（存储的是原本最新插的牌）
            for (j = i; j > 0 && num1[j - 1] > temp; j--) {
                //移出空牌
                num1[j] = num1[j - 1];
                System.out.println(Arrays.toString(num1));
            }
            //插牌
            num1[j] = temp;

        }
        return num1;
    }

    public int[] BubbleSort(int[] num1, int length) {
        int i, j;
        //这里做一个优化，如果初始是有序的数组了,则flag为true，也就是 第一趟 下来没有进行过任何交换
        boolean flag = true;
        for (j = length - 1; j > 0; j--) {
            //第一趟排序
            for (i = 0; i < j; i++) {
                if (num1[i] > num1[i + 1]) {
                    int tmp = num1[i];
                    num1[i] = num1[i + 1];
                    num1[i + 1] = tmp;
                    flag = false;
                    System.out.println(Arrays.toString(num1));
                }
            }
            if (flag) break;
        }

        return num1;
    }

    public int[] SelectionSort(int[] num1, int length) {
        int i, j;
        int maxIndex = 0;
        for(i = length-1;i>0;i--) {
            for (j = 0; j < i+1; j++) {
                //选择排序法注意这里是找到最大值下标
                if (num1[j] > num1[maxIndex]) {
                    maxIndex = j;
                }
            }
            //最大值和最后一位进行交换
            int tmp = num1[i];
            num1[i] = num1[maxIndex];
            num1[maxIndex] = tmp;
        }
        return num1;
    }

}
