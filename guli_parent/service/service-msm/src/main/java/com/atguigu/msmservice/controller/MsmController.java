package com.atguigu.msmservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.commonutils.RandomUtil;
import com.atguigu.msmservice.service.MsmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
//@CrossOrigin
@RequestMapping("/edumsm/msm")
public class MsmController {
    @Autowired
    private MsmService msmService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //    发送短信的方法
    @GetMapping("send/{phoneNum}")
    public R send(@PathVariable String phoneNum) {
//        从redis获取验证码，如果取到则直接返回
        String phoneCheck = redisTemplate.opsForValue().get(phoneNum);
        System.out.println(phoneCheck);
        if (!StringUtils.isEmpty(phoneCheck)) {
            return R.ok();
        }
//        生成随机值，传递给阿里云发送
        String code = RandomUtil.getSixBitRandom();
        Map<String, Object> param = new HashMap<>();
        param.put("code", code);
//        调用发送短信的方法
        boolean isSend = msmService.sendMsg(param, phoneNum);
        if (isSend) {
//            发送成功，把发送验证码放到redis里面去（设置有效时间，存放验证码）
            redisTemplate.opsForValue().set(phoneNum, code, 3600, TimeUnit.MINUTES);
            return R.ok();
        } else {
            return R.error().message("发送短信失败");
        }
    }
}
