package com.MyGeneric.Demo2;

//具体类实现泛型接口
public class GenericImpl<T> implements MyGenericInterface<T> {

    @Override
    public void show(T t) {
        System.out.println(t);
    }

}
