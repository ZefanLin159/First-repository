package com.atguigu.statistics.service;

import com.atguigu.statistics.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author testJava
 * @since 2022-08-08
 */
public interface DailyService extends IService<Daily> {

    void registerCount(String date);

    Map<String, Object> getShowData(String type, String begin, String end);
}
