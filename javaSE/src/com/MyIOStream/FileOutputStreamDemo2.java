package com.MyIOStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\Program\\javaSE\\src\\com\\MyIOStream\\fos.txt");
        //等价写法
//        FileOutputStream fos2 = new FileOutputStream(new File("E:\\Program\\javaSE\\src\\com\\MyIOStream\\fos.txt"));


//        byte[] b = {97, 98, 99, 100, 101};
//        b[0] = (byte)98;
//        fos.write(b);
//        fos.close();
        //更简便的写法
        byte[] b = "abandon".getBytes(StandardCharsets.UTF_8);
        fos.write("abide".getBytes());

        fos.write(b,0,3);
        fos.close();

    }
}
