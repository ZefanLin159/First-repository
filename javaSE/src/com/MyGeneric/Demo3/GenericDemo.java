package com.MyGeneric.Demo3;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        //<?>任意类型的通配符，有点像excel里面的?
        List<?> list1 = new ArrayList<Object>();
        List<?> list2 = new ArrayList<Number>();
        List<?> list3 = new ArrayList<Integer>();

        //类型通配符上限 不能超过父类
        // List<?extends Number> = new ArrayList<Object>();会报错

        //类型通配符下限 不能低于子类
        // List<? super Number> = new ArrayList<Integer>();会报错
    }
}
