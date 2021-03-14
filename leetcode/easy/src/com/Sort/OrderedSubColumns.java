package com.Sort;

import java.util.Arrays;

public class OrderedSubColumns {

    public static void main(String[] args) {
        //注意是有序子列，其实也可以是分开的两条链表（线性表即可）
        int[] num1 = {8,9,10,11,1,2,4,5,6};
        OrderedSubColumns osc = new OrderedSubColumns();
        //这里输入要注意，rEnd是线性表中最后一个元素的下标
        int[] n1 = osc.merge(num1,0,4,num1.length-1);
        System.out.println(Arrays.toString(n1));
    }

    public int[] merge(int[] num1,int lStart,int rStart,int rEnd){
        int[] newNum= new int[num1.length];
        int lEnd = rStart -1;
        int i = 0;
        while (lStart <=lEnd && rStart <= rEnd) {
            if (num1[lStart] <= num1[rStart]) {
                newNum[i++] = num1[lStart++];
            } else {
                newNum[i++] = num1[rStart++];
            }
        }
            while (lStart<=lEnd){
                newNum[i++] = num1[lStart++];
            }
            while (rStart<=rEnd){
                newNum[i++] = num1[rStart++];
            }
        //这里可能需要补充一个小细节，后面注意


        return newNum;
    }
}
