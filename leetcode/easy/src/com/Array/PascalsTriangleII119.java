package com.Array;

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
                }else {
                   cur.add(pre.get(j)+pre.get(j-1));
                }
            }
            pre = cur;//只是一个预存值，可以想办法把pre简化掉，节省O(N)空间
        }

        return cur;
    }

    public static void main(String[] args) {

    }
}
class Solution119{
    //怎么简化pre呢，明天继续思考，当作复习
}