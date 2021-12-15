package com.lzf.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {
    public static String getId() {
//        生成随机id
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDUtils.getId());
    }
}
