package com.MyMap.Demo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {
        //HashMap同样键值，会将前面的键值对应的value覆盖掉
        //HashMap可以参考leetcode第一题
        Map<String, String> map = new HashMap<String, String>();
        map.put("001", "lqx");
        map.put("002", "zmy");
        map.put("003", "wzx");
        map.put("004", "xxx");
        map.put("003", "lsp");


        System.out.println(map);


    }
}
