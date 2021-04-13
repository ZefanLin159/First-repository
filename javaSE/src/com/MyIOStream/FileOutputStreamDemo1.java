package com.MyIOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("E:\\Program\\javaSE\\src\\com\\MyIOStream\\fos.txt");
        /**
         * 1.调用系统功能创捷了文件
         * 2.创建了字节输出流对象
         * 3.让字节输出流对象指向创建好的文件
         */
        //用txt文件打开时是字符型
        fos.write(98);

        //最后要释放资源
        fos.close();//关闭此文件输出流并释放与此相关联的任何系统资源


    }
}
