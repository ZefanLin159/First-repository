package myTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list1 = new ArrayList<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur= cur.left;
            }
            cur = stack.pop();
            list1.add(cur.val);
            cur = cur.right;
        }
        for(int i = 0;i<list1.size()-1;i++){
            if(list1.get(i) >= list1.get(i+1)) return false;
        }
        return true;
    }
}
