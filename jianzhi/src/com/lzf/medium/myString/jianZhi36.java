package com.lzf.medium.myString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class jianZhi36 {



    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        char[] path = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[path.length];
        recur(path, sb, visited);
        return set.toArray(new String[0]);
    }

    private void recur(char[] ch, StringBuilder sb, boolean[] visited) {
        if (sb.length() == ch.length) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (visited[i]) continue;
            sb.append(ch[i]);
            visited[i] = true;
            recur(ch, sb, visited);//回溯到下一层直至结束
            // 撤销选择??
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false; //当前循环完毕，重置访问标志位
        }
    }

}
