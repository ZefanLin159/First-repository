package com.lzf.easy.Tree;

import com.lzf.TreeNode;

public class jianZhi68_1 {


    public static void main(String[] args) {


        TreeNode head = new TreeNode(6);
        TreeNode node = new TreeNode(2);
        head.left = node;
        TreeNode node1 = new TreeNode(8);
        head.right = node1;
        TreeNode node2 = new TreeNode(0);
        head.left.left = node2;
        TreeNode node3 = new TreeNode(4);
        head.left.right = node3;
        TreeNode node4 = new TreeNode(7);
        head.right.left = node4;
        TreeNode node5 = new TreeNode(9);
        head.right.right = node5;
        jianZhi68_1 jz68_1 = new jianZhi68_1();
        System.out.println(jz68_1.lowestCommonAncestor(head, node3,node2).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) { // 保证 p.val < q.val
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while(root != null) {
            if(root.val < p.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if(root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
        //
    }


}
