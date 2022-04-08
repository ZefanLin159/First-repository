package com.lzf.medium.Array;

public class jianZhi12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean res;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //这里k不动的原因是要在深度遍历里面去增加
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || word[k] != board[i][j]) return false;
        if (k == word.length - 1) return true; //dfs找到最后一个字母
        char temp = board[i][j];
        //遍历过程中，处理掉遍历过的字符，免得重复遍历
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);

//        还原遍历前清除的字符
        board[i][j] = temp;
        return res;
    }

}
