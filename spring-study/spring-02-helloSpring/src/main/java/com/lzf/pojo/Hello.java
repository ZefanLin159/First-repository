package com.lzf.pojo;

public class Hello {
    private String str;

//    核心是set控制注入，有叶子说明被spring托管了
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
