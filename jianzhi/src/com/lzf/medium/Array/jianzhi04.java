package com.lzf.medium.Array;

public class jianzhi04 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 4, 5},
                {2, 7, 8, 9},
                {6, 10, 12, 13},};
//        System.out.println(matrix[10]);
        boolean existFlag = findNumberIn2DArray(matrix, 15);
        System.out.println(existFlag);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        boolean findFlag = false;
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                findFlag = true;
                break;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return findFlag;
    }
}
