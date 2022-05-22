package RecurOrDpOrDFS;

import java.util.ArrayList;
import java.util.List;

//全排列
public class leetCode46 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        recur(list, new ArrayList<Integer>(), nums, visited, 0, len);
        return list;

    }

    private void recur(List<List<Integer>> list, ArrayList<Integer> path, int[] nums, boolean[] visited, int depth, int len) {
        if (depth == len) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                recur(list, path, nums, visited, depth + 1, len);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }


    }


//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        int len = nums.length;
//        boolean[] visited = new boolean[len];
//        int depth = 0;
//        recur(list, new ArrayList<Integer>(), visited, nums, depth, len);
//        return list;
//    }
//
//    private void recur(List<List<Integer>> list, ArrayList<Integer> path, boolean[] visited, int[] nums, int depth, int len) {
//        if (depth == len) {
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!visited[i]) {
////              添加当前层节点并将状态设置为访问过
//                path.add(nums[i]);
//                visited[i] = true;
//
////                System.out.println("未回溯前的path值是："+path);
//                recur(list, path, visited, nums, depth + 1, len);
////                System.out.println("回溯后的path值是："+path);
//
////              回溯完返回上一层，删除下一层的节点状态并删除下一层的节点，在树中的表现（返回上一层）
//                visited[i] = false;
//                path.remove(path.size() - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        leetCode46 lc46 = new leetCode46();
        System.out.println(lc46.permute(new int[]{1, 2, 3, 4}));
    }
}
