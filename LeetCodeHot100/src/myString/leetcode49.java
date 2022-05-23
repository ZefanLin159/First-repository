package myString;

import java.lang.reflect.Array;
import java.util.*;

//单词异位词分组
public class leetcode49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        leetcode49 lc49 = new leetcode49();
        System.out.println(lc49.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = String.valueOf(word);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(key, tmp);
            }
        }
        list.addAll(map.values());
        return list;
    }
}
