package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.entity.frontVo.CourseFrontVo;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-07-22
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private EduChapterService eduChapterService;


    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
//        向课程表添加课程基本信息
        int insert = baseMapper.insert(eduCourse);
//        向课程简介表添加课程简介
        if (insert <= 0) {
            throw new GuliException(20001, "添加课程信息失败");
        }
//        获取添加课程后的id(统一课程描述表和课程表的id）
        String newInsertId = eduCourse.getId();
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(newInsertId);
        boolean flag = courseDescriptionService.save(courseDescription);
        return newInsertId;
    }

    @Override
    public CourseInfoVo getCourseByCourseId(String courseId) {
//        查询课程表
        EduCourse eduCourse = baseMapper.selectById(courseId);
//        查询课程描述表
        EduCourseDescription eduCourseDescription = courseDescriptionService.getById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        BeanUtils.copyProperties(eduCourseDescription, courseInfoVo);
        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
//        修改课程表
        int update = baseMapper.updateById(eduCourse);
        if (update <= 0) {
            throw new GuliException(20001, "修改课程表失败");
        }
//        修改描述表
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo, eduCourseDescription);
        QueryWrapper<EduCourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("id", courseInfoVo.getId());
        boolean flag = courseDescriptionService.update(eduCourseDescription, wrapper);
        if (!flag) {
            throw new GuliException(20001, "修改描述表失败");
        }

    }

    @Override
    public CoursePublishVo getCoursePublishVo(String courseId) {
        return baseMapper.coursePublish(courseId);
    }

    @Override
    public void removeCourse(String courseId) {
//        根据课程id删除小节
        eduVideoService.removeVedioByCourseId(courseId);
//        根据课程id删除章节
        eduChapterService.removeChapterByCourseId(courseId);
//        根据课程id删除课程本身
        courseDescriptionService.removeById(courseId);
        int i = baseMapper.deleteById(courseId);
        if (i <= 0) {
            throw new GuliException(20001, "删除失败");
        }

    }

    @Override
    public Map<String, Object> getFrontCourseList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo) {
        QueryWrapper<EduCourse> courseWrapper = new QueryWrapper<>();
        String subjectParentId = courseFrontVo.getSubjectParentId();
        String subjectId = courseFrontVo.getSubjectId();
        String priceSort = courseFrontVo.getPriceSort();
        String buyCountSort = courseFrontVo.getBuyCountSort();
        String gmtCreateSort = courseFrontVo.getGmtCreateSort();
        if (!StringUtils.isEmpty(subjectParentId)) {
            courseWrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            courseWrapper.eq("subject_id", subjectId);
        }
        if (!StringUtils.isEmpty(priceSort)) {
            courseWrapper.orderByDesc("price");
        }
        if (!StringUtils.isEmpty(buyCountSort)) {
            courseWrapper.orderByDesc("buy_count");
        }
        if (!StringUtils.isEmpty(gmtCreateSort)) {
            courseWrapper.orderByDesc("gmt_create");
        }
        baseMapper.selectPage(pageCourse, courseWrapper);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("pageCourse", pageCourse);
        return map;
    }


}
