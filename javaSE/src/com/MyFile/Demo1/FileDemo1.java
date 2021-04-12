package com.MyFile.Demo1;

import java.io.File;

public class FileDemo1 {
    //路径名只是抽象形式，并不一定要存在
    public static void main(String[] args) {
        //同样的file构造方法，共三种
        File f1 = new File("E:\\itCast\\java.txt");
        System.out.println(f1);

        File f2 = new File("E:\\itCast", "java.txt");
        System.out.println(f2);

        File f3 = new File("e:\\itCast");
        File f4 = new File(f3, "java.txt");
    }

}
