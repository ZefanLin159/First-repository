package com.lzf.medium.Array;

import java.util.Arrays;

public class jianZhi29 {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]
//                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13}};
        int[][] matrix = new int[][]
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        System.out.println("l=" + l + ",r=" + r + ",t=" + t + ",b=" + b);
        System.out.println(Arrays.toString(spiralOrder(matrix)));

    }
//
//    public static int[] spiralOrder(int[][] matrix) {
//        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
//        int[] res = new int[(r + 1) * (b + 1)];
//        while (true) {
//            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
//
//        }
//        return res;
//    }


    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];

            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];

            if (--r < l) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];

            if (--b < t) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];

            if (++l > r) break;
        }
        return res;
    }

}
