package com.lzf.medium.Array;

public class jianZhi47 {
    public static void main(String[] args) {
        jianZhi47 jianZhi47 = new jianZhi47();
        System.out.println(jianZhi47.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
//    建议明天用不扩容的方式写试试
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[row][column];
    }

}
