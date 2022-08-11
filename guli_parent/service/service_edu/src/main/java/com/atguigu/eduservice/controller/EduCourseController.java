package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.commonutils.vo.CourseVoForOrder;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.*;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/eduService/course")
//@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    //    添加课程基本信息的方法
    /*TODO:需要返回课程id*/
    @PostMapping("addCourse")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String courseId = courseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId", courseId);
    }

    //    根据课程查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseByCourseId(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    //修改课程信息
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    //获取课程vo
    @GetMapping("getCoursePublishInfo/{courseId}")
    public R getCoursePublishInfo(@PathVariable String courseId) {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(courseId);
        return R.ok().data("coursePublishVo", coursePublishVo);
    }

    //    课程发布
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        courseService.updateById(eduCourse);
        return R.ok();
    }

    //    课程列表
    @GetMapping("findAllCourse")
    public R findAllCourse() {
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("list", list);
    }

    //    分页查询课程方法
    /*currentPage 当前页
     * limit 每页记录数*/
    @GetMapping("pageCourse/{currentPage}/{limit}")
    public R pageCourse(@PathVariable Long currentPage, @PathVariable Long limit) {
        Page<EduCourse> pageCourse = new Page<>(currentPage, limit);
        courseService.page(pageCourse, null);
        List<EduCourse> records = pageCourse.getRecords();
        long total = pageCourse.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("records", records);
        return R.ok().data(map);
    }

    //    条件查询带分页方法
    @PostMapping("pageCourseCondition/{current}/{limit}")
    public R pageCourseCondition(@PathVariable long current, @PathVariable long limit,
                                 @RequestBody(required = false) CourseQuery courseQuery) {
        Page<EduCourse> coursePage = new Page<>(current, limit);
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
//        多条件组合查询（动态sql）
        if (courseQuery != null) {
            String title = courseQuery.getTitle();
            String status = courseQuery.getStatus();

            if (!StringUtils.isEmpty(title)) {
                wrapper.like("title", title);
            }
            if (!StringUtils.isEmpty(status)) {
                wrapper.eq("status", status);
            }
        }

        wrapper.orderByDesc("gmt_create");
//        调用page方法相当于把查询到的数据注入到pageTeacher中
        courseService.page(coursePage, wrapper);
        long total = coursePage.getTotal();
        List<EduCourse> records = coursePage.getRecords();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    //    删除课程
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable String courseId) {
        courseService.removeCourse(courseId);

        return R.ok();
    }

    @GetMapping("{courseId}")
    public CourseVoForOrder getCourseById(@PathVariable("courseId") String courseId){
        EduCourse course = courseService.getById(courseId);
        CourseVoForOrder courseVoForOrder = new CourseVoForOrder();
        BeanUtils.copyProperties(course,courseVoForOrder);

       return courseVoForOrder;
    }
}


