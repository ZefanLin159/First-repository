package com.lzf.pojo;

//实体类
public class User {
    private int id;
    private String name;
    private String passwords;

    public User(int id, String name, String passwords) {
        this.id = id;
        this.name = name;
        this.passwords = passwords;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswords() {
        return passwords;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwords='" + passwords + '\'' +
                '}';
    }
}
