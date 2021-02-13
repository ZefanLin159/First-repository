package com.display;

public class Clock {
    private Display hours = new Display(24);
    private Display minutes = new Display(60);

    public void start() {

        while (true) {
            minutes.increase();
            if (minutes.getValue() == 0) {
                hours.increase();
            }
            System.out.printf(" %02d: %02d \n", hours.getValue(), minutes.getValue());
        }
    }

    //static 类变量（不属于任何具体对象），可以通过 类名.变量 或 对象.变量 来访问。
    // static+函数名 类函数
    //static 中不能访问non-static域
    public static void main(String args[]) {
        Clock clock = new Clock();
        clock.start();


    }
}

//对象是鸡蛋，对象中的数据是蛋黄，对象中的操作是蛋白，包装成鸡蛋的过程就是封装
//对象=属性+服务
//private 只能用于成员变量或成员函数（在类的外面不可访问了）
//只有这个类内部可以访问：1.类内部指类的成员函数和定义初始化2.这个限制对象是针对类的而不是函数。
//如果没有public private,那么成为friendly，同一个包的可以访问
//public 都可以访问