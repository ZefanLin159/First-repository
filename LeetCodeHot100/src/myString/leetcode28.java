package myString;

public class leetcode28 {
    public static void main(String[] args) {
        leetcode28 leetcode28 = new leetcode28();
        System.out.println(leetcode28.strStr("abc", "c"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] words = needle.toCharArray();
        int i, j = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        boolean flag = false;
        boolean recordFlag = false;
        for (i = 0; i < haystack.length(); i++) {
    //        这里有问题，不是很合理 输入“abc” “c“会出问题
            if (j == words.length - 1) {
                flag = true;
                break;
            }
            if (haystack.charAt(i) == words[j]) {
                if (!recordFlag) leftIndex = i;
                recordFlag = true;
                j++;
            } else {
                recordFlag = false;
                j = 0;
                leftIndex = 0;
            }
        }
        if (!flag) return -1;
        return leftIndex;

    }
}
