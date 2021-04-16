package com.MyIOStream.MyCharacterStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src\\com\\MyIOStream\\MyCharacterStream\\osw.txt"));
        osw.write(97);
        //存在缓冲区,需要刷新
        osw.flush();
        //关闭以后会把缓冲区的文件刷新，相当于用了一次flush后再释放资源
        osw.close();

        char[] chs = {'a','b','c','d','e'};
        osw.write(chs,0,chs.length);



    }

}
