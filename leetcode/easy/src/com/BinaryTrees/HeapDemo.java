package com.BinaryTrees;

import java.lang.annotation.ElementType;
import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        Heap maxHeap = new Heap(8);
        maxHeap.insertHeapValue(maxHeap, 1);
        maxHeap.insertHeapValue(maxHeap, 2);
        maxHeap.insertHeapValue(maxHeap, 3);
        maxHeap.insertHeapValue(maxHeap, 4);
        maxHeap.insertHeapValue(maxHeap, 5);
        maxHeap.insertHeapValue(maxHeap, 6);
        maxHeap.insertHeapValue(maxHeap, 7);
        maxHeap.insertHeapValue(maxHeap, 8);
        maxHeap.insertHeapValue(maxHeap, 9);
        System.out.println(Arrays.toString(maxHeap.elementTypes));
    }

}

class Heap {
    int[] elementTypes;
    int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //+1是给一个哨兵的空间
        this.elementTypes = new int[capacity + 1];
        int maxData = Integer.MAX_VALUE;
        this.elementTypes[0] = maxData;
    }

    public int getSize() {
        return size;
    }

    /**
     * @param heap  传入堆，注意堆的首元素是哨兵
     * @param value 传入要插入的值
     */
    public void insertHeapValue(Heap heap, int value) {
        int i;
        int heapSize = heap.getSize();
        if (heapSize == heap.capacity) {
            System.out.println("堆已满");
            return;
        }
        //将i指向堆中最后一个元素的后面
        i = ++heap.size;
        //哨兵元素控制结束条件
        for (; heap.elementTypes[i / 2] < value; i /= 2) {
            //向下过滤结点，将父结点的数据放入当前i指向的位置
            //因为父节点的值小于value，所以要下放
            heap.elementTypes[i] = heap.elementTypes[i / 2];
        }
        heap.elementTypes[i] = value;
    }

    //删除最大堆元素
    //先保留完全性，再调整有序性
    public int deleteHeapValue(Heap heap){
        int parent,child;
        int maxData = 0,temp;
        int heapSize = heap.getSize();
        if(heapSize == 0){
            System.out.println("堆已空，删除失败");
            return Integer.MIN_VALUE;
        }
        //取出最大值
        maxData = heap.elementTypes[1];
        //用最大堆中最后一个元素从根结点开始自上而下过滤结点
        temp = heap.elementTypes[heap.size--];
        return maxData;
    }
}