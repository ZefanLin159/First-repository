package com.BinaryTrees;

import java.lang.annotation.ElementType;
import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        Heap maxHeap = new Heap(5);
        maxHeap.insertHeapValue(maxHeap, 58);
        maxHeap.insertHeapValue(maxHeap, 44);
        maxHeap.insertHeapValue(maxHeap, 25);
        maxHeap.insertHeapValue(maxHeap, 45);
        maxHeap.insertHeapValue(maxHeap, 31);
        //这里返回的数组没有删除堆末的元素,不过size确实变小了，所以暂时理解为合理
        maxHeap.deleteHeapValue(maxHeap);
        maxHeap.insertHeapValue(maxHeap,1);
        System.out.println(Arrays.toString(maxHeap.elementTypes));
    }

}

class Heap {
    //1
    int[] elementTypes;
    int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //+1是给一个哨兵的空间，哨兵的空间不包含在size和capacity里面
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
        //堆中有多少个元素则有多少个size，不包括哨兵
        //后面要插入元素，提前加1，并且方便i指向堆中待插入元素的位置（如果符合堆规则）
        heap.size++;
        i = heap.size;
        //哨兵元素控制结束条件，循环条件是每次都往父节点走
        for (; heap.elementTypes[i / 2] < value; i /= 2) {
            //向下过滤结点，将父结点的数据放入当前i指向的位置
            //因为父节点的值小于value，所以要下放
            heap.elementTypes[i] = heap.elementTypes[i / 2];
        }
        heap.elementTypes[i] = value;
    }

    //删除最大堆元素
    //先保留完全性，再调整有序性
    public int deleteHeapValue(Heap heap) {
        int parent, child;
        int maxData = 0, temp;
        int heapSize = heap.getSize();
        if (heapSize == 0) {
            System.out.println("堆已空，删除失败");
            return Integer.MIN_VALUE;
        }
        //取出最大值
        maxData = heap.elementTypes[1];
        //用最大堆中最后一个元素从根结点开始自上而下过滤结点
        //这里为了便于理解，分成两条语句
        temp = heap.elementTypes[heap.size];
        heap.size--;
        //这里结束条件是要判断是否存在左儿子，如果没有（那么必然也没有右儿子），则退出循环
        //双指针，parent指向父结点，child指向子结点（增加左右结点的判断），如果父结点大或者没有子节点，则退出循环
        for (parent = 1; parent * 2 <= heap.size; parent = child) {
            child = parent * 2;
            //if的判断条件不能交换，我们要确定这个二叉树中是否存在右节点
            if (child != heap.size && (heap.elementTypes[child] < heap.elementTypes[child + 1])) {
                child++;
            }
            if (temp >= heap.elementTypes[child]) break;
            else {
                heap.elementTypes[parent] = heap.elementTypes[child];
            }

        }
        heap.elementTypes[parent] = temp;
        return maxData;
    }
}