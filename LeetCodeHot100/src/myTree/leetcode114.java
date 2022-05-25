package myTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//二叉树展开为链表
public class leetcode114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        TreeNode temp = root;
        for(int i = 1;i<list.size();i++){
            temp.left = null;
            temp.right = list.get(i);
            temp = temp.right;
        }
    }
}

