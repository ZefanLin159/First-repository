package com.MyIOStream.MyFileStream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//字节流写数据实现换行
/*
   window:\r\n
   linux:\n
   mac:\r
 */
public class FileOutputStreamDemo3 {

    public static void main(String[] args) throws IOException {
        //true实现追加写入
        FileOutputStream fos = new FileOutputStream("src\\com\\MyIOStream\\fos3.txt", true);

        for (int i = 0; i < 5; i++) {
            fos.write("我是谁".getBytes(StandardCharsets.UTF_8));
            //不同操作系统的换行符不同
            fos.write("\n".getBytes(StandardCharsets.UTF_8));
        }

        //怎么实现追加写入
        fos.close();

    }
}
