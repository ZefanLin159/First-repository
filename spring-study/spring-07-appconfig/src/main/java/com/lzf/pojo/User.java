package com.lzf.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    private String name;

    @Value("小林")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
