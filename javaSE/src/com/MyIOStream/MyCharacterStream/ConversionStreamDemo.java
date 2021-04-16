package com.MyIOStream.MyCharacterStream;

import java.io.*;

//读取字符数据
public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字符流输出对象,输入（输出流对象，编码）
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                "src\\com\\MyIOStream\\MyCharacterStream\\osw.txt"), "UTF-8");

        osw.write("中国");
        osw.close();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(
                "src\\com\\MyIOStream\\MyCharacterStream\\osw.txt"), "UTF-8");
        int by;
        while ((by = isr.read()) != -1) {
            System.out.print((char) by);
        }
        isr.close();
    }
}
