package com.lzf.medium.Tree;

public class jianZhi33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right) {
//        说明只剩下一个节点，单节点必然是二叉搜索树
        if (left >= right) return true;
//        后序遍历最后一个索引对应根节点
        int root = postorder[right];
        int index = left;
//        找出左子树
        while (postorder[index] < root) {
            index++;
        }
//        右子树如果有小于根节点的树，则不是二叉搜索树
        int m = index;
        while (index++ < right) {
            if (postorder[index] < root) {
                return false;
            }
        }
//        分治判断左右子树是不是二叉搜索树
        boolean leftTree = recur(postorder, left, m - 1);
        boolean rightTree = recur(postorder, m, right - 1);
        return leftTree && rightTree;

    }
}
