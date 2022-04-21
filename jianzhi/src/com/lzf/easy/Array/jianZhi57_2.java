package com.lzf.easy.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jianZhi57_2 {

    public static void main(String[] args) {
        jianZhi57_2 jianZhi57_2 = new jianZhi57_2();
        System.out.println(Arrays.deepToString(jianZhi57_2.findContinuousSequence(15)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        if (target < 3) return new int[][]{};
        int i = 1, j = 2, sum = i + 2;
        while (i < j) {
            int[] subList = new int[j - i + 1];
            if (sum == target) {
                for (int k = i; k <= j; k++) {
                    subList[k] = k;
                }
                list.add(subList);
            }
//            超过了或者刚刚好，移动i
            if (sum >= target) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }
        return list.toArray(new int[0][]);
    }
//    public int[][] findContinuousSequence(int target) {
//        if (target < 3) return new int[][]{};
//        List<int[]> list = new ArrayList<>();
//        int i = 1, j = 2, s = i + j;
//        while (i < j) {
//            int[] subArray = new int[j - i + 1];
//            if (s == target) {
//                for (int k = i; k <= j; k++) {
//                    subArray[k - i] = k;
//                }
//                list.add(subArray);
//            }
//            if (s >= target) {
//                s -= i;
//                i++;
//            } else {
//                j++;
//                s += j;
//            }
//        }
//        return list.toArray(new int[0][]);
//    }
}
