package com.lzf.pojo;

public class User {
    private String name;

//    无参构造
//    public User(){
//        System.out.println("User的无参构造");
//    }
//    有参
    public User(String name){
        this.name = name;
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
