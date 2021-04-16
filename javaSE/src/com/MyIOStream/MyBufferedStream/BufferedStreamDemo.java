package com.MyIOStream.MyBufferedStream;

import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\com\\MyIOStream\\MyBufferedStream\\bw.txt"));
        BufferedReader br = new BufferedReader(new FileReader("src\\com\\MyIOStream\\MyBufferedStream\\bos.txt"));
        FileWriter fw = new FileWriter("src\\com\\MyIOStream\\MyBufferedStream\\bos.txt");
        BufferedWriter bw1 = new BufferedWriter(fw);
        for (int i = 0; i < 4; i++) {
            fw.write("Hello");
            fw.write("\n");
            fw.write("World");
            fw.write("\n");
        }
        //还没有写进去，要加flush
        fw.flush();
        //换种可以写字符串
        bw.write("baby");
        //写换行符
        bw.newLine();
        //要刷新
        bw.flush();

        //特有功能，可以读取行
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        int len;
        char[] ch = new char[1024];
        //字符流一般采用这种读取方式
        while ((len = br.read(ch)) != -1) {
            bw.write(new String(ch, 0, len));
        }

        bw1.close();
        fw.close();
        bw.close();
        br.close();
    }
}
