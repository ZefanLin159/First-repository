package com.MyFile.Demo2;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    public static void main(String[] args) {
        File f1 = new File("e:\\itCast\\java.txt");
        try {
            //如果文件不存在则创建文件返回true
            //不能根据路径名判断生成的是文件还是目录，要看调用的方法
            //有了重名目录以后，无法成功创建重名文件
            System.out.println(f1.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建目录（文件夹）
        File f2 = new File("e:\\itCast\\javaSe");
        System.out.println(f2.mkdir());

        //创建多级目录
        File f3 = new File("e:\\itCast\\JavaWEB\\HTML");
        System.out.println(f3.mkdirs());

    }

}
