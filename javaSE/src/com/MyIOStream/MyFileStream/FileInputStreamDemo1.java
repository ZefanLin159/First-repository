package com.MyIOStream.MyFileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo1 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\com\\MyIOStream\\fos4.txt");
            int by;
            //读取技巧，和c一样
            while ((by = fis.read()) != -1) {
                System.out.print((char) by);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
