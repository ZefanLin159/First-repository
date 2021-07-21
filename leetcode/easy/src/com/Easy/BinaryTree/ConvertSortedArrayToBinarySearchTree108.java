package com.Easy.BinaryTree;

public class ConvertSortedArrayToBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecursive(nums,0,nums.length-1);//左闭右开
    }

    public TreeNode sortedArrayToBSTRecursive(int[] nums,int left,int right){
        if(left == right) return null;
        //这样求mid可以避免溢出，而>>1相当于/2
        int mid = left+((right-left)/2);
        //递归技巧 相当于找3个节点 第一个节点从数组中位切分
        //然后开始用分治算法，（左闭右开）还不是太理解
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTRecursive(nums,left,mid-1);
        root.right = sortedArrayToBSTRecursive(nums,mid+1,right);
        return root;
    }
}
