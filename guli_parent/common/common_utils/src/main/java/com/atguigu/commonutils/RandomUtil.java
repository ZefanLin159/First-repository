package com.atguigu.commonutils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    private static final DecimalFormat fourdf = new DecimalFormat("0000");
    private static final DecimalFormat sixdf = new DecimalFormat("000000");

    public static String getFourBitRandom() {
        return fourdf.format(random.nextInt(10000));
    }

    public static String getSixBitRandom() {
        return fourdf.format(random.nextInt(1000000));
    }

    public static ArrayList<Object> getRndom(List list, int n) {
        Random random = new Random();
        HashMap<Object, Object> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int number = random.nextInt(100) + 1;
            map.put(number, i);
        }
        Object[] robjs = map.values().toArray();
        ArrayList<Object> r = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            r.add(list.get((int) robjs[i]));
            System.out.println(list.get((Integer) robjs[i]) + "\t");
        }
        System.out.println("\n");
        return r;
    }
}
