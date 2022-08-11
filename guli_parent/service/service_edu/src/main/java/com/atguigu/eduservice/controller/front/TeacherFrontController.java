package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping("/eduService/teacherfront")
public class TeacherFrontController {
    @Autowired
    EduTeacherService eduTeacherService;

    //    分页查询讲师的方法
    @GetMapping("getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page, @PathVariable long limit) {
        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        Map<String, Object> map = eduTeacherService.getTeacherFrontList(teacherPage);
        return R.ok().data(map);
    }

    @GetMapping("getTeacherById/{id}")
    public R getTeacherById(@PathVariable String id) {
        EduTeacher singleTeacher = eduTeacherService.getById(id);
        return R.ok().data("singleTeacher", singleTeacher);
    }

    @GetMapping("getCourseById/{teacherId}")
    public R getCourseById(@PathVariable String teacherId) {
        List<EduCourse> courseList = eduTeacherService.getCourse(teacherId);
        return R.ok().data("courseList",courseList);
    }
}
