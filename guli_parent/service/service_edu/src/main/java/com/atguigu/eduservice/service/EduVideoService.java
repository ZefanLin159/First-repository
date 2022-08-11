package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author testJava
 * @since 2022-07-22
 */
public interface EduVideoService extends IService<EduVideo> {

    boolean removeChapterById(String videoId);

    void removeVedioByCourseId(String courseId);
}
