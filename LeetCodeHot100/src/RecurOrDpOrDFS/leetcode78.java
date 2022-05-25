package RecurOrDpOrDFS;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.ArrayList;
import java.util.List;

//子集
public class leetcode78 {
    public static void main(String[] args) {
        leetcode78 lc78 = new leetcode78();
        System.out.println(lc78.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        recur(list, new ArrayList<Integer>(), 0, nums);
        return list;
    }

    private void recur(List<List<Integer>> list, ArrayList<Integer> path, int start, int[] nums) {
        list.add(new ArrayList<>(path));
//        i是单调递增的所以不会有重复
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
//            System.out.println("dfs前" + list);
            recur(list, path, i + 1, nums);
//            System.out.println("dfs后" + list);
            path.remove(path.size() - 1);
        }

    }
}
