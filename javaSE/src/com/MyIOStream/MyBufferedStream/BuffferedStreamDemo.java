package com.MyIOStream.MyBufferedStream;

import java.io.*;

public class BuffferedStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("E:\\Program\\javaSE\\src\\com\\MyIOStream\\MyBufferedStream\\bos.txt"));
        bos.write("hello\n".getBytes());
        bos.write("world\n".getBytes());

        bos.close();

        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("E:\\Program\\javaSE\\src\\com\\MyIOStream\\MyBufferedStream\\bos.txt"));
        //一次读取一个字节数据
//        int by;
//        while ((by = bis.read()) != -1) {
//            System.out.print((char) by);
//        }
        //一次读取多个字节数据
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        bis.close();
    }
}
