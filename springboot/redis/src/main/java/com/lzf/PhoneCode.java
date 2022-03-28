package com.lzf;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
//        String code = getCode();
//        System.out.println(code);
//        模拟验证码发送


        verifyCode("1378492839");
//        getRedisCode("1378492839", "312198");
    }

    //   1 生成6位数字验证码
    public static String getCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int i1 = random.nextInt(10);
            code.append(i1);
        }
        return code.toString();
    }


    //    2 每个手机每天只能发送3次
    public static void verifyCode(String phone) {
//        连接redis
        Jedis jedis = new Jedis("192.168.89.128", 6379);
        jedis.auth("passerby159lzf");
//        拼接key

//        手机发送次数key
        String countKey = "VerifyCode" + phone + "count";
//        验证码key
        String codeKey = "VerifyCode" + phone + "code";

//        每个手机每天只能发送3次
        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
//            发送三次不能再发送
            System.out.println("今天发送次数已经超过三次");
//            关闭jedis
            jedis.close();
            return;
        }
//        发送验证码放到redis里面
        String vCode = getCode();
        jedis.setex(codeKey, 120, vCode);
        jedis.close();

    }

    // 3   验证码校验
    public static void getRedisCode(String phone, String code) {
//        从redis获取验证码

        Jedis jedis = new Jedis("192.168.89.128", 6379);
        jedis.auth("passerby159lzf");
//        验证码key
        String codeKey = "VerifyCode" + phone + "code";
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        jedis.close();
    }
}
