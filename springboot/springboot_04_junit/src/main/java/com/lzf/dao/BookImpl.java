package com.lzf.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookImpl implements BookDao{
    @Override
    public void save() {
        System.out.println("boodao is running");
    }
}
