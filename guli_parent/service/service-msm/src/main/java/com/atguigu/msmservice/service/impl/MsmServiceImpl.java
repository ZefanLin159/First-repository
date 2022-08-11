package com.atguigu.msmservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.msmservice.service.MsmService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.models.*;
import com.aliyun.teautil.models.*;

import java.util.Map;

@Service
public class MsmServiceImpl implements MsmService {

    @Override
    public boolean sendMsg(Map<String, Object> param, String phoneNum) {
        if (StringUtils.isEmpty(phoneNum)) return false;
        com.aliyun.dysmsapi20170525.Client client = null;
        try {
            client = createClient("LTAI5t5mVvh3iitkcxSVgPkv", "5bXqNvwOyR1MstfvS6oLQm4xEomJKF");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SendSmsRequest sendSmsRequest = new SendSmsRequest().setPhoneNumbers(phoneNum)
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setTemplateParam(JSONObject.toJSONString(param));
        ;
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            SendSmsResponse response = client.sendSmsWithOptions(sendSmsRequest, runtime);
            return response.getBody().getMessage().equals("OK");
        } catch (Exception e) {
            // 如有需要，请打印 error
            e.printStackTrace();
            return false;
        }
    }

    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws
            Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}
