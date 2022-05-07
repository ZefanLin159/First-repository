package myTree;

import java.util.HashMap;

public class leetCode105 {
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

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(preorder, 0, 0, inorder.length - 1);
    }

    public TreeNode recur(int[] preorder, int preRoot, int inLeft, int inRight) {
        if (inLeft >= inRight) return null;
        TreeNode node = new TreeNode(preorder[preRoot]);
        int i = map.get(preorder[preRoot]);
        node.left = recur(preorder, preRoot + 1, inLeft, i - 1);
        node.right = recur(preorder, preRoot + inLeft - i + 1, i + 1, inRight);
        return node;
    }
}
