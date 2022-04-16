package com.lzf.medium.dp;

public class jianZhi13 {
    int m, n;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        visited = new boolean[m][n];
        return dfs(0, 0, k);

    }

    private int dfs(int i, int j, int k) {
        if (i >= m || j >= n || sumVal(i, j) > k || visited[i][j]) return 0;
//        代表这个格子访问过
        visited[i][j] = true;
//        没必要向上或者向左的原因是不必重复访问，访问过的visit都会赋值为真
        return dfs(i + 1, j, k) + dfs(i, j + 1, k) + 1;
    }

    private int sumVal(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
