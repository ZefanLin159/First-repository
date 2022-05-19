package RecurOrDp;

import java.util.ArrayList;
import java.util.List;

public class leetCode39 {
    public static void main(String[] args) {
        leetCode39 lc39 = new leetCode39();
        System.out.println(lc39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        recur(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void recur(List<List<Integer>> list, ArrayList<Integer> path, int[] candidates, int remain, int start) {
        if (remain >= 0) {
            if (remain == 0) {
                list.add(new ArrayList<>(path));
                return;
            } else {
//              这里有个起始遍历点（没有剪枝）
//              明天尝试一下剪枝
                for (int i = start; i < candidates.length; i++) {
                    path.add(candidates[i]);
                    recur(list, path, candidates, remain - candidates[i], i);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
