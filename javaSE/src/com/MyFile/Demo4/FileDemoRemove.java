package com.MyFile.Demo4;

import java.io.File;
import java.io.IOException;

public class FileDemoRemove {
    public static void main(String[] args) throws IOException {
        //无法用相对路径创建文件？为什么（“javaSE\\java.txt")会出现问题
        //只能这样创建文件了
        File f1 = new File("java.txt");
        System.out.println(f1.createNewFile());
        //返回true说明删除成功
        System.out.println(f1.delete());
        System.out.println("---------------");

        //只能用绝对路径创建目录和文件，不知道是为何
        File f2 = new File("E:\\Program\\javaSE\\src\\com\\MyFile\\Demo4\\itCast");
        System.out.println(f2.mkdir());
        System.out.println(f2.delete());
        //
        File f3 = new File("itCast");
        System.out.println(f3.mkdir());
        File f4 = new File(f3, "java.txt");
        System.out.println(f4.createNewFile());
        //删除目录前应该先删除目录下的内容后才能删除
        System.out.println(f4.delete());
        System.out.println(f3.delete());

    }
}
