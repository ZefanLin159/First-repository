package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.entity.frontVo.CourseFrontVo;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping("/eduService/coursefront")
public class CourseFrontController {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;
    @Autowired
    private EduCourseDescriptionService descriptionService;
    @Autowired
    private EduSubjectService subjectService;
    @Autowired
    private EduChapterService chapterService;

    @PostMapping("getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit, @RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> pageCourse = new Page<>(page, limit);
        Map<String, Object> map = courseService.getFrontCourseList(pageCourse, courseFrontVo);
//        map.put("total", pageCourse.getTotal());
//        map.put("pages", pageCourse.getPages());
//        map.put("records", pageCourse.getRecords());
        return R.ok().data(map);
    }

    @GetMapping("getAllSubjectFront")
    public R getAllSubject() {

        List<OneSubject> subjectList = subjectService.getAllOneTwoSubject();
        return R.ok().data("subjectList", subjectList);
    }

    @GetMapping("getCourseById/{courseId}")
    public R getCourseById(@PathVariable String courseId) {
        EduCourse singleCourse = courseService.getById(courseId);
        EduCourseDescription description = descriptionService.getById(singleCourse.getId());
        EduTeacher teacher = teacherService.getById(singleCourse.getTeacherId());
        List<ChapterVo> chapterVoList = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("singleCourse", singleCourse).data("description",description).data("teacher",teacher).data("chapterVoList",chapterVoList);
    }

}
