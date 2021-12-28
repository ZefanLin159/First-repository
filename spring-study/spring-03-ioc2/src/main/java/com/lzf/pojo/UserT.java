package com.lzf.pojo;

public class UserT {
    private String name;

    public UserT(){
        System.out.println("userT被创建了");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void show() {
        System.out.println("name=" + name);
    }
}
