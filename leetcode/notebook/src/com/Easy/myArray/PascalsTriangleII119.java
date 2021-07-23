package com.Easy.myArray;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            //初始化新行号的值，这句话很重要，漏了会把之前的数据保留进来
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;//只是一个预存值，可以想办法把pre简化掉，节省O(N)空间
        }

        return cur;
    }

    public static void main(String[] args) {

    }
}

class Solution119 {
    //怎么简化pre呢，明天继续思考(没有想出来），参考的
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1); //第一个数永远都是1
        //注意这里i是从1开始遍历的，否则每一层会多出来一个1
        //如果从0开始，rowIndex = 0时，就会执行一次循环，加上上面的add（1），输出就变成了[1,1]，这里要注意
        for (int i = 1; i <= rowIndex; i++) {
            //注意倒序的好处是为了避免数据溢出，因为往上一层取数据时数组会比本层短，所以j要取对应数据位。
            //这里最好不要用顺序遍历
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));//注意cur.get仍然是从上一层取出
            }
            cur.add(1);//这里的技巧是当上面所有数据遍历完时，add是往末尾添加的。
        }
        return cur;
    }
}