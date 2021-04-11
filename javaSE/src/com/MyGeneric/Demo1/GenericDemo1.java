package com.MyGeneric.Demo1;

//在类处加<>则是泛型类
public class GenericDemo1 {
    //泛型方法
    public <T> GenericDemo1(T t) {
        System.out.println(t);
    }
}
