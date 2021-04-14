package com.MyIOStream.MyCharacterStream;
/*
    一个汉字存储：第一个字节一定是负数，方便识别为汉字
        如果是GBK编码，占用2个字节,
        如果是UTF-8编码，占用3个字节
 */


import java.io.FileInputStream;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Program\\javaSE\\src\\com\\MyIOStream\\fos4.txt");
//        int len;
//        byte[] bys = new byte[1024];
//        while ((len = fis.read(bys)) != -1) {
//            System.out.println(new String(bys, 0, len));
//        }
        int by;
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);//汉字输出乱码 ä¸­å½
        }


        fis.close();
    }
}
