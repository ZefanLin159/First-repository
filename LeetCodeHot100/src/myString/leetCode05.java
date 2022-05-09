package myString;

public class leetCode05 {
    public static void main(String[] args) {
        leetCode05 lc05 = new leetCode05();
        System.out.println(lc05.longestPalindrome("bb"));

    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int begin = 0;
        int maxLen = 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
