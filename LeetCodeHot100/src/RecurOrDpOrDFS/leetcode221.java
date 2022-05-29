package RecurOrDpOrDFS;

//最大正方形
public class leetcode221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '1', '1', '0'},
                {'1', '1', '1', '0'},
                {'1', '1', '1', '0'},
                {'1', '1', '1', '1'}
        };
        leetcode221 lc221 = new leetcode221();
        System.out.println(lc221.maximalSquare(matrix));

//        System.out.println();
    }

    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }
}
