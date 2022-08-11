package com.atguigu.statistics.service.impl;

import com.atguigu.commonutils.RandomUtil;
import com.atguigu.statistics.client.UcenterClient;
import com.atguigu.statistics.entity.Daily;
import com.atguigu.statistics.mapper.DailyMapper;
import com.atguigu.statistics.service.DailyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-08-08
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements DailyService {

    @Autowired
    private UcenterClient ucenterClient;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void registerCount(String date) {
        QueryWrapper<Daily> wrapper = new QueryWrapper<>();
        wrapper.eq("date_calculated", date);
        baseMapper.delete(wrapper);

//            int i = 1 / 0;

        int count = ucenterClient.getRegisterCount(date);
        Daily daily = new Daily();
        daily.setDateCalculated(date);
        daily.setRegisterNum(count);

//        这里属实乱写的（培训机构给的随机数)
        daily.setVideoViewNum(RandomUtils.nextInt(100, 200));
        daily.setLoginNum(RandomUtils.nextInt(100, 200));
        daily.setCourseNum(RandomUtils.nextInt(100, 200));

        baseMapper.insert(daily);
    }

    @Override
    public Map<String, Object> getShowData(String type, String begin, String end) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Daily> wrapper = new QueryWrapper<>();
        wrapper.between("date_calculated", begin, end);
        wrapper.select("date_calculated", type);
        List<Daily> list = baseMapper.selectList(wrapper);

//     需求：返回日期数组和日期对应数量数组，但是前端要求json结构
//        创建List集合
        List<String> date_calculatedList = new ArrayList<>();
        List<Integer> numDateList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Daily daily = list.get(i);
            date_calculatedList.add(daily.getDateCalculated());
            switch (type) {
                case "login_num":
                    numDateList.add(daily.getLoginNum());
                    break;
                case "register_num":
                    numDateList.add(daily.getRegisterNum());
                    break;
                case "video_view_num":
                    numDateList.add(daily.getVideoViewNum());
                    break;
                case "course_num":
                    numDateList.add(daily.getCourseNum());
                    break;
                default:
                    break;
            }
        }
        map.put("date_calculatedList", date_calculatedList);
        map.put("numDateList", numDateList);
        return map;
    }

}
