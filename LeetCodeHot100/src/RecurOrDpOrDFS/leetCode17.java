package RecurOrDpOrDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的组合
public class leetCode17 {
    public static void main(String[] args) {
        leetCode17 lc17 = new leetCode17();
        System.out.println(lc17.letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
//        这里要排除空字符串的情况
        if (digits.length() == 0) return new ArrayList<>(0);
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> list = new ArrayList<>();
        int len = digits.length();
//        这里要用stringBuilder（其他的就好理解了）
        recur(list, map, new StringBuilder(), digits, 0, len);
        return list;
    }

    private void recur(List<String> list, Map<Character, String> map, StringBuilder sb, String digits, int index, int len) {
        if (index == len) {
            list.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String str = map.get(digit);
            int letterCount = str.length();
            for (int i = 0; i < letterCount; i++) {
                sb.append(str.charAt(i));
                recur(list, map, sb, digits, index + 1, len);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
