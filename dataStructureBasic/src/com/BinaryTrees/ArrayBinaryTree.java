package com.BinaryTrees;

//顺序存储结构的二叉树通常只考虑完全二叉树
//第n个元素的左子节点是2*n+1
//第n个元素的右子节点是2*n+2
//第n个元素的父结点是（n-1）/2
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow(int index){
        if(data == null||data.length == 0)return;
        System.out.println(data[index]);
        //2*index + 1


    }
}
