//package com.atguigu.msmservice.util;
//
//import io.lettuce.core.dynamic.annotation.Value;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ConstantMsmUtils implements InitializingBean {
//    public static String ACCESS_KEY_ID;
//    public static String ACCESS_KEY_SECRET;
//    //读取配置文件内容
//    @Value("${aliyun.msm.file.keyid}")
//    private String accessKeyId;
//
//    @Value("${aliyun.msm.file.keysecret}")
//    private String accessKeySecret;
//
//
//    //    定义公开静态常量
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        ACCESS_KEY_ID = accessKeyId;
//        ACCESS_KEY_SECRET = accessKeySecret;
//
//    }
//}