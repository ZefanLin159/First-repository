package com.MyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//编译异常：必须显示处理，否则程序报错，无法通过编译（文件读取，文件写入异常）
//运行时异常，无需显示处理(数组越界异常）

//如果用throws抛出异常，则程序不会往下运行，
// 想让程序继续运行，还是得使用try catch
public class MyExceptionDemo {
    public static void main(String[] args) {

    }

    public static void method() {
        String s = "2048-08-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            //编译异常：有可能会出现异常，但不是一定会出现异常
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
    }


}
