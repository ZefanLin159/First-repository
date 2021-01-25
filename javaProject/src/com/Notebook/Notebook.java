package com.Notebook;

import java.util.ArrayList;

class Value {
    private int i;

    public void set(int i) {
        this.i = i;
    }

    public int get() {
        return i;
    }
}

public class Notebook {
    //容器(范型）;有顺序
    private ArrayList<String> notes = new ArrayList<String>();

    public void add(String s) {
        notes.add(s);
    }

    public void add(int index, String s) {
        //在第index个元素前插入
        notes.add(index, s);
    }

    public int getSize() {
        return notes.size();
    }

    public String getNote(int index) {
        return notes.get(index);

    }

    public boolean removeNot(int index) {
        notes.remove(index);
        return true;
    }

    public String[] list() {
        String[] a = new String[notes.size()];
//        for (int i = 0;i<notes.size();i++){
//            a[i] = notes.get(i);
//        }
        notes.toArray(a);//将容器的数值逐个填入字符串对象中
        return a;
    }

    public static void main(String[] args) {

        //基础类型数组
        int[] test1 = new int[10];
        //对象类型数组：对象数组中的每个元素都是对象的管理者而非他本身
        String[] test2 = new String[2];
        Notebook nb = new Notebook();
        nb.add("first");
        nb.add("second");
        nb.add("third");
        nb.add(0, "zero");
        nb.removeNot(0);
        System.out.printf("size = " + nb.getSize() + "\n");
        System.out.println(nb.getNote(2));
        System.out.println(nb.getNote(0));
        String[] a = nb.list();
        //foreach 写法，对每一个进行遍历
        for (String s : a) {
            System.out.println(s);
        }
        System.out.println("----------------");
        //for-each的解释
        Value[] z = new Value[10];
        for (int i = 0; i < z.length; i++) {
            z[i] = new Value();
            z[i].set(i);
        }
        for (Value k : z) {
            System.out.println(k.get());
            k.set(0);
        }
        for ( Value v:z){
            System.out.println(v.get());
        }
    }
}
