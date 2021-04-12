package com.MyFile.Demo3;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        //??
        File f = new File(" myFile\\java.txt");
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());//和视频结果不同
        System.out.println(f.exists());//和视频结果不同
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getPath());
        System.out.println(f.getName());

        System.out.println("----------------");
        File f2 = new File("e:\\itCast");
        //获得当前路径的子目录
        String[] arrayList = f2.list();
        for (String str : arrayList) {
            System.out.println(str);
        }
        System.out.println("----------------");
        //获得f2的绝对路径
        File[] listFiles = f2.listFiles();
        for (File file : listFiles) {
            System.out.println(file);
        }
        System.out.println("----------------");
        for(File file:listFiles){
            //只获得目录下的文件
            if(file.isFile())
            System.out.println(file.getName());
        }
        System.out.println("----------------");



    }
}
