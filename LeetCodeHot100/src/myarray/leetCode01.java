package myarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class leetCode01 {
    public static void main(String[] args) {
        leetCode01 lc01 = new leetCode01();
        //[3,3] [3,2,6]
        System.out.println("请输入几个数并用逗号隔开：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = Integer.parseInt(arr[j]);
        }
        Scanner sc2 = new Scanner(System.in);
        String str2 = sc2.next();
        int target = Integer.parseInt(str2);
        System.out.println(Arrays.toString(lc01.twoSum(nums, target)));

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val) && map.get(val) != i) {
                return new int[]{i, map.get(val)};
            }
        }

        throw new IllegalArgumentException("not find");
    }
}
