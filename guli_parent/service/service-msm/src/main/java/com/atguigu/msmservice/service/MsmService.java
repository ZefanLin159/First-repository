package com.atguigu.msmservice.service;

import java.util.Map;

public interface MsmService {
    boolean sendMsg(Map<String, Object> param, String phoneNum);
}
