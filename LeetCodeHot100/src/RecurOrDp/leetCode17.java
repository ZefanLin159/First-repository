package RecurOrDp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的组合
public class leetCode17 {
    public static void main(String[] args) {
        leetCode17 lc17 = new leetCode17();
        System.out.println(lc17.letterCombinations("423"));
    }

    public List<String> letterCombinations(String digits) {
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
        recur(list, new StringBuilder(), map, digits, 0, digits.length());
        return list;
    }

    private void recur(List<String> list, StringBuilder sb, Map<Character, String> map, String digits, int depth, int len) {
        if (depth == len) {
            list.add(sb.toString());
        } else {
            char digit = digits.charAt(depth);
            String letters = map.get(digit);
            int letterLen = letters.length();
            for (int i = 0; i < letterLen; i++) {
                sb.append(letters.charAt(i));
                recur(list,sb,map,digits,depth+1,len);
                sb.deleteCharAt(sb.length()-1);
            }

        }


    }
}
