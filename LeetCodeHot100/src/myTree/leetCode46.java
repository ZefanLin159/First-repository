package myTree;

import java.util.ArrayList;
import java.util.List;

//全排列
public class leetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int depth = 0;
        recur(list, new ArrayList<Integer>(), visited, nums, depth, len);
        return list;
    }

    private void recur(List<List<Integer>> list, ArrayList<Integer> path, boolean[] visited, int[] nums, int depth, int len) {
        if (depth == len) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
            }
            recur(list, path, visited, nums, depth + 1, len);
            visited[i] = false;
//            删除一个结点，在树中的表现（返回上一层）
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        leetCode46 lc46 = new leetCode46();
        System.out.println(lc46.permute(new int[]{1, 2, 3}));
    }
}
