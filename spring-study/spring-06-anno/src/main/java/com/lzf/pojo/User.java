package com.lzf.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@COmponent 等价于 <bean id="user" class="com.lzf.pojo.User"/>
@Component
public class User {
    public String name;

    @Value("kuangshen")
    public void setName(String name) {
        this.name = name;
    }
}
