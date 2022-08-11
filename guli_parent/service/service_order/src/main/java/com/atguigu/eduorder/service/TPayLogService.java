package com.atguigu.eduorder.service;

import com.atguigu.eduorder.entity.TPayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author testJava
 * @since 2022-08-07
 */
public interface TPayLogService extends IService<TPayLog> {

    Map<String, Object> createNative(String orderId);

    Map<String, String> queryPayStatus(String orderId);

    void updateOrdersStatus(Map<String, String> map);
}
