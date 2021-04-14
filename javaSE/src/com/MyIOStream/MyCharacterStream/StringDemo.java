package com.MyIOStream.MyCharacterStream;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "中国";
        byte[] bytes1 = s.getBytes("UTF-8");
        byte[] bytes2 = s.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));//输出字节数组的数据
        System.out.println(Arrays.toString(bytes2));
        String ss1 = new String(bytes1);//输出字符串数据
        System.out.println(ss1);
        String ss2 = new String(bytes1, "GBK");
        System.out.println(ss2);//输出乱码，因为本平台默认使用UTF-8的编码，所以用GBK解码会有问题


    }
}
