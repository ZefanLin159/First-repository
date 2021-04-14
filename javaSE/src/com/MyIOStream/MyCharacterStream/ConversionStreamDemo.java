package com.MyIOStream.MyCharacterStream;

import java.io.*;

//读取字符数据
public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字符流输出对象,输入（输出流对象，编码）
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                "E:\\Program\\javaSE\\src\\com\\MyIOStream\\MyCharacterStream\\osw.txt"), "GBK");

        osw.write("中国");
        osw.close();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(
                "E:\\Program\\javaSE\\src\\com\\MyIOStream\\MyCharacterStream\\osw.txt"), "GBK");
        int by;
        while ((by = isr.read()) != -1) {
            System.out.print((char) by);
        }
        isr.close();
    }
}
