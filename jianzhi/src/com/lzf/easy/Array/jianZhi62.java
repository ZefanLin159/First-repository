package com.lzf.easy.Array;

import java.util.ArrayList;
import java.util.List;

public class jianZhi62 {
    public static void main(String[] args) {
        jianZhi62 jianZhi62 = new jianZhi62();
        System.out.println(jianZhi62.lastRemaining(10, 17));
    }


    public int lastRemaining(int n, int m) {
        int dp = 0;
        for(int i = 2;i<=n;i++){
            dp = (dp+m)%i;
        }
        return dp;
    }
}
