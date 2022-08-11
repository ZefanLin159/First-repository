package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.mapper.EduVideoMapper;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-07-22
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Autowired
    private EduVideoService videoService;
    @Autowired
    private VodClient vodClient;

    @Override
    public boolean removeChapterById(String videoId) {
        boolean flag = false;
//        根据chapter_id查询小节，如果有数据则不删除
        QueryWrapper<EduVideo> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("chapter_id", videoId);
        if (videoService.count(videoQueryWrapper) != 0) {
            flag = false;
            throw new GuliException(20001, "不能删除");
        } else {
            int result = baseMapper.deleteById(videoId);
            if (result <= 0) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    //TODO 根据课程小节删除阿里云已上传的视频
    @Override
    public void removeVedioByCourseId(String courseId) {
//        根据课程id查询课程所有的视频id(先删视频,再删小节）
        QueryWrapper<EduVideo> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("course_id", courseId);
        videoQueryWrapper.select("video_source_id");
        List<EduVideo> eduVideoList = baseMapper.selectList(videoQueryWrapper);
        List<String> sourceIds = new ArrayList<>();

        for (int i = 0; i < eduVideoList.size(); i++) {
            EduVideo eduVideo = eduVideoList.get(i);
            if (eduVideo != null) {
                String videoSourceId = eduVideo.getVideoSourceId();
                if (videoSourceId != null) {
                    sourceIds.add(videoSourceId);
                }
            }
        }

        if (sourceIds.size() > 0) {
            vodClient.deleteVideoAliList(sourceIds);
        }

        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        baseMapper.delete(wrapper);
    }
}
