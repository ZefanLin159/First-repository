package com.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        //总的二维数组，ArrayList是一个可变数组，最后要返回但是List，所以创建该对象为List
        List<List<Integer>> ans = new ArrayList<>();//创建总的数组
        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();//代表子列中的数组
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> last = ans.get(i-1);
                    sub.add(last.get(j-1)+last.get(j));
                }
            }
            ans.add(sub);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
