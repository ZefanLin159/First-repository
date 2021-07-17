package com.Easy.BinaryTree;

public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(right - left) > 1) {
            return false;
        }
        //还不是很理解这句话的意义？左子树和右子树平衡？
        return isBalanced(root.left) && isBalanced(root.right);
//        return true;不能直接返回true，参考这种情况[1,2,2,3,null,null,3,4,null,null,4]
    }

    public int maxDepth(TreeNode p) {
        if (p == null) return 0;
        return Math.max(maxDepth(p.left), maxDepth(p.right)) + 1;

    }

    public boolean isBalanced_2(TreeNode root) {
        return maxDepth_2(root) != -1;
    }

    public int maxDepth_2(TreeNode p) {
        if (p == null) return 0;
        int left = maxDepth_2(p.left);
        if(left == -1) return -1;
        int right = maxDepth_2(p.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>1) return -1;

        //前面已经用了一个寄存器得出来递归值了，不要重复递归！！！
        return Math.max(left, right) + 1;

    }
}
