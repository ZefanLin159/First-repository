package com.atguigu.statistics.schedule;

import com.atguigu.statistics.service.DailyService;
import com.atguigu.statistics.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    private DailyService dailyService;

    @Scheduled(cron = "0 0 22 * * ?")
    public void timerTask() {
        dailyService.registerCount(DateUtils.getYestoday());
    }
}
