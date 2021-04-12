package com.MyFile.Demo5;

import java.io.File;

//利用递归读取某目录下的所有文件（包含子目录下）
public class FileDemo5 {
    public static void main(String[] args) {
        File srcFile = new File("C:\\Users\\lzf\\Desktop\\有关noma的文章");
        getAllFilePath(srcFile);

    }

    public static void getAllFilePath(File srcFile) {
        //获取给定的file目录下所有的文件或者目录的file数组
        File[] filesArray = srcFile.listFiles();
        if (filesArray != null) {
            for (File file : filesArray) {
                if (file.isDirectory()) {
                    //递归调用读取子目录，直到找到文件为止
                    getAllFilePath(file);
                } else {
                    //退出条件
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
