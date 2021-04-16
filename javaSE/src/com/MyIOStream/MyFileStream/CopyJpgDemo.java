package com.MyIOStream.MyFileStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyJpgDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("e:\\itCast\\mn.jpg");
        FileOutputStream fos = new FileOutputStream("src\\com\\MyIOStream\\mn.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            //这里要注意一下，区间要填0到len,否则读取的图片有可能不全
            fos.write(bytes, 0, len);
        }

        fis.close();
        fos.close();
    }
}
