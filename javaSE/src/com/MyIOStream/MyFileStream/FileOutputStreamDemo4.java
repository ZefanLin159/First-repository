package com.MyIOStream.MyFileStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
    异常的几个处理方法
    getMessage():返回此Throwable的详细信息字符串
    toString():返回此可抛出的简短描述
    printStackTrace():把异常的错误信息输出在控制台
 */

public class FileOutputStreamDemo4 {
    public static void main(String[] args) {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("e:\\Program\\javaSE\\src\\com\\MyIOStream\\fos4.txt");
            fos.write("Hello".getBytes());
            fos.write("\n".getBytes());
            fos.write("World".getBytes());
        } catch (IOException e) {
            e.printStackTrace();//输出信息是最全的
        } finally {
            if (fos != null) {
                try {
                    fos.close();//一定要释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
