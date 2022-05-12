package myTree;

import java.util.ArrayList;
import java.util.List;

public class leetCode39 {
    public static void main(String[] args) {
        leetCode39 lc39 = new leetCode39();
        System.out.println(lc39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> subList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            list.add(new ArrayList<>(subList));//这里要指定添加subList
        } else {
            for (int i = start; i < candidates.length; i++) {
                subList.add(candidates[i]);
                dfs(list, subList, candidates, remain - candidates[i], i);
                subList.remove(subList.size() - 1);
            }
        }
    }
//    明天尝试一下剪枝
}
