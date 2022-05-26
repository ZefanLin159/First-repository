package myarray;

import java.lang.reflect.Array;
import java.util.Arrays;

//数组中的第k个最大元素
public class leetcode215 {
    public static void main(String[] args) {
        leetcode215 lc215 = new leetcode215();
        System.out.println(lc215.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            int count = 0;
            int i = nums.length - 1;
            while (i > 0) {
                count++;
                if(count == k) break;
                i--;
            }
            return nums[i];
    }
}
