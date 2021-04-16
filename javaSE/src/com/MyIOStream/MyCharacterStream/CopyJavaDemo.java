package com.MyIOStream.MyCharacterStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//字符流复制文件
public class CopyJavaDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src\\com\\MyIOStream\\MyCharacterStream\\StringDemo.java");
        FileWriter fw = new FileWriter("src\\com\\MyIOStream\\MyCharacterStream\\Copy.java");

//        int ch;
//        while ((ch = fr.read()) != -1) {
//            fw.write(ch);
//        }

        char[] ch = new char[1024];
        int len;
        while ((len = fr.read(ch)) != -1) {
            fw.write(new String(ch, 0, len));
        }

        fw.close();
        fr.close();

    }
}
