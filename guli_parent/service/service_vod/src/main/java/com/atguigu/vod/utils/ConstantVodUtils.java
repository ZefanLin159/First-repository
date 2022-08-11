package com.atguigu.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * 读取配置文件内容
 * */
@Component
public class ConstantVodUtils implements InitializingBean {
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public  static String END_POINT;
    //读取配置文件内容
    @Value("${aliyun.vod.file.keyid}")
    private String accessKeyId;

    @Value("${aliyun.vod.file.keysecret}")
    private String accessKeySecret;
    @Value("${aliyun.vod.file.endpoint}")
    private String endPoint;

    //    定义公开静态常量
    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        END_POINT = endPoint;

    }
}
