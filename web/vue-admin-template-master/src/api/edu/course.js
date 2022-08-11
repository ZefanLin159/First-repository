import request from '@/utils/request'

// 接口地址
// 1.讲师列表（条件查询带分页）
export default {
    addCourseInfo(courseInfoVo) {
        return request({
            url: `eduService/course/addCourse`,
            method: 'post',
            // data标识把对象转换json传递到接口里面
            data: courseInfoVo
        })
    },
    getAllTeacher() {
        return request({
            url: `eduService/teacher/findAll`,
            method: 'get',
        })
    },
    // 根据课程id查询课程基本信息
    getCourseInfo(courseId) {
        return request({
            url: `/eduService/course/getCourseInfo/${courseId}`,
            method: 'get',
        })
    },
    // 修改课程信息
    updateCourseInfo(courseInfoVo) {
        return request({
            url: `/eduService/course/updateCourseInfo`,
            method: 'post',
            data: courseInfoVo,
        })
    },
    // 课程列表
    pageCourse(current, limit) {
        return request({
            url: `/eduService/course/pageCourse/${current}/${limit}`,
            method: 'get',
        })
    },

    pageCourseListPage(current, limit, courseQuery) {
        return request({
            url: `eduService/course/pageCourseCondition/${current}/${limit}`,
            method: 'post',
            data: courseQuery
        })
    },
    deleteCourse(courseId){
        return request({
            url: `eduService/course/${courseId}`,
            method: 'delete'
        })
    }
}
