package com.lzf;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.89.128", 6379);
        jedis.auth("passerby159lzf");
        System.out.println(jedis.ping());
        jedis.close();
    }

    //    操作key
    @Test
    public void demo1() {
        Jedis jedis = new Jedis("192.168.89.128", 6379);
        jedis.auth("passerby159lzf");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        jedis.close();

    }
    @Test
    public void demo2(){
        Jedis jedis = new Jedis("192.168.89.128", 6379);
        jedis.auth("passerby159lzf");
        jedis.flushAll();
        jedis.close();
    }
}
