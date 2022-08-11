package com.atguigu.eduorder.client;

import com.atguigu.commonutils.R;
import com.atguigu.commonutils.vo.CourseVoForOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "service-edu")
public interface GetCourseClient {
    @GetMapping("/eduService/course/{courseId}")
    public CourseVoForOrder getCourseById(@PathVariable("courseId") String courseId);

}
