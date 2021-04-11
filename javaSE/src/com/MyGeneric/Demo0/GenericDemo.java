package com.MyGeneric.Demo0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class GenericDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();

        c.add("hello");
        c.add("world");
        c.add("java");

        //Collection 实现了Iterator接口
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }

    }
}

