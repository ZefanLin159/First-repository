package com.lzf.medium.Tree;

import com.lzf.TreeNode;

import java.util.HashMap;

public class jianZhi07 {

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int preRoot = 0, inLeft = 0, inRight = inorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            //本题只适用无重复数字的原因
            map.put(inorder[i], i);
        }
        return recur(preRoot, inLeft, inRight);


    }

    public TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(preorder[preRoot]);
        int index = map.get(node.val);
        node.left = recur(preRoot + 1, inLeft, index - 1);
        node.right = recur(preRoot + (index - inLeft) + 1, index + 1, inRight);
        return node;
    }
}
