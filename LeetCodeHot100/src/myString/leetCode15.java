package myString;

import java.util.*;

public class leetCode15 {

    public static void main(String[] args) {
        leetCode15 lc15 = new leetCode15();
        System.out.println(lc15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //    这个思路不太对(排序+双指针）
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return list;
        for (int k = 0; k < len - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = len - 1;
            while (i < j) {
                List<Integer> subList = new ArrayList<>();
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    subList.add(nums[k]);
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    list.add(subList);
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {
                    while (i < j && nums[j] == nums[--j]) ;
                }

            }

        }
        return list;
    }

//    //    这个思路不太对
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (nums.length < 3) return list;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
//        int i = 0;
//        List<Integer> subList = new ArrayList<>();
//        for (int j = i + 1; j < nums.length; j++) {
//            int sub = -nums[i] - nums[j];
//            if (map.containsKey(sub) && map.get(sub) != j) {
//                subList.add(nums[i]);
//                subList.add(nums[j]);
//                subList.add(sub);
//            }
//        }
//        list.add(subList);
//
//        return list;
//    }
}
