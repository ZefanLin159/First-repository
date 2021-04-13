package com.MyIOStream.MyFileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Program\\javaSE\\src\\com\\MyIOStream\\fos4.txt");
/*
        byte[] by = new byte[5];

        int len = fis.read(by);
        System.out.println(len);
        System.out.println(new String(by,0,len));

        int len2 = fis.read(by);
        System.out.println(len2);
        System.out.println(new String(by,0,len));

        //读入缓冲区的字节个数，最大不超过byte数组的长度
        int len3 = fis.read(by);
        System.out.println(len3);
        //这里为什么输出是dWorl呢，是因为是从0开始写的，但读到的只有1个数据，所以其他四个byte就保留了

//        System.out.println(new String(by));//这里应该改进一下,改成实际读取长度
        System.out.println(new String(by,0,len));

        len = fis.read(by);
        System.out.println(len);//输出为-1说明已经到达末尾了
*/
        //从缓冲区读取法
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        fis.close();
    }
}
