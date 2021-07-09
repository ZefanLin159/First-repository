package com.Easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal94And144And145 {

    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal94(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
//        while (temp != null || stack.isEmpty() == false) {
//            while (temp != null) {
//                stack.push(temp);
//                temp = temp.left;
//            }
//            if (!stack.isEmpty()) {
//                temp = stack.pop();
//                list.add(temp.val);
//                temp = temp.right;
//            }
//
//        }
        while (temp != null || stack.isEmpty() == false) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal144(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {//这里是or
            //前序和中序的区别  在于list.add位置的区别，切记，切记
            if (temp != null) {
                list.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            } else {
//            if(!stack.isEmpty()){//前序遍历不能利用栈来判断，只能用temp指向来判断，eg[1,null,2,3];
                temp = stack.pop();
                temp = temp.right;
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null && !stack.isEmpty()) {
            if(temp!=null){

            }else {

            }
        }

        return list;
    }

}
