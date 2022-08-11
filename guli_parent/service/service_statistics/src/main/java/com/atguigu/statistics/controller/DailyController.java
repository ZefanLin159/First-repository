package com.atguigu.statistics.controller;


import com.atguigu.commonutils.R;
import com.atguigu.statistics.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-08-08
 */
@RestController
@RequestMapping("/statistics/daily")
//@CrossOrigin
public class DailyController {

    @Autowired
    private DailyService dailyService;

    //    统计某一天注册人数，生成统计表数据库
    @PostMapping("registerCount/{date}")
    public R registerCount(@PathVariable("date") String date) {
        if (date == null) {
            return R.error().message("请输入日期");
        }
        dailyService.registerCount(date);
        return R.ok();
    }

    //    图表显示，返回两部分数据，日期json数组，数量json数组
    @GetMapping("showData/{type}/{begin}/{end}")
    public R showData(@PathVariable("type") String type, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        Map<String, Object> map = dailyService.getShowData(type,begin,end);

        return R.ok().data(map);
    }
}

