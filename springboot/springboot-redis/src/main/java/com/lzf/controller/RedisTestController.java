package com.lzf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping
    public String testRedis() {
        redisTemplate.opsForValue().set("name", "lucy");
//        从redis获取值
        String name = redisTemplate.opsForValue().get("name");
        return name;
    }

}
