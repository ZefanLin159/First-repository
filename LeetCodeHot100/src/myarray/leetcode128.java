package myarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//最长连续子序列
public class leetcode128 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        leetcode128 lc128 = new leetcode128();
        System.out.println(lc128.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
//            相等要跳过
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                maxLen = Math.max(maxLen, count);
                count = 1;
            }
        }
//        这里是因为又能已经跳出了没有获取到相对大的那个值
        return Math.max(count, maxLen);
    }
}
