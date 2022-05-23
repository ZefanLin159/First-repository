package RecurOrDpOrDFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//单词拆分
public class leetcode139 {
    public static void main(String[] args) {
        String word = "leetcode";
        String subWord = word.substring(0,4);

        leetcode139 lc139 = new leetcode139();
        List<String> list = new ArrayList<>();

        list.add("leet");
        list.add("code");
        System.out.println(lc139.wordBreak1("leetcode", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        int[] memory = new int[size];
        Set<String> wordSet = new HashSet<>(wordDict);
        return recur(s, size, wordSet, 0, memory);
    }

    private boolean recur(String s, int size, Set<String> wordSet, int start, int[] memory) {
        if (start == size) return true;
        if (memory[start] != 0) {
            return memory[start] == 1;
        }
        for (int i = start; i < size; i++) {
            String word = s.substring(start, i + 1);
            boolean flag = recur(s, size, wordSet, i + 1, memory);
            if (wordSet.contains(word) && flag) {
                memory[start] = 1;
                return true;
            }
        }
        memory[start] = 2;
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && set.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

}


