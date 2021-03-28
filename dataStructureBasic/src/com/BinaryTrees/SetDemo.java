package com.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class SetDemo {
    public static void main(String[] args) {
        SetType[] set = new SetType[5];
        set[0] = new SetType(1, -1);
        set[1] = new SetType(2, 0);
        set[2] = new SetType(3, -1);
        set[3] = new SetType(4, 0);
        set[4] = new SetType(5, 2);
        int x = findSet(5, set);
        System.out.println(x);
    }

    public static int findSet(int x, SetType[] setType) {
        int i = 0;
        int maxSize = setType.length;
        for (; i < maxSize && setType[i].elementTypes != x; i++) ;
        if (i >= maxSize) return -1;
        //找到树根，返回树根的下标，结束条件是不满足树根结点的位置
        //在此处就是parent的下标为-1
        for (; setType[i].parent >= 0; i = setType[i].parent) ;
        return i;
    }
}

class SetType {
    int elementTypes;
    int parent;

    /**
     * @param elementTypes 数组的元素
     * @param parent       指向对应的数组下标
     */
    public SetType(int elementTypes, int parent) {
        this.elementTypes = elementTypes;
        this.parent = parent;
    }

}