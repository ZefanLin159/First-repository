import request from '@/utils/request'
export default {
    getFrontCourseList(page,limit,courseVo) {
        return request({
            url: `/eduService/coursefront/getFrontCourseList/${page}/${limit}`,
            method: 'post',
            data:courseVo
        })
    },
    getAllSubject() {
        return request({
            url: `/eduService/coursefront/getAllSubjectFront`,
            method: 'get',
        })
    },
    getCourseById(courseId){
        return request({
            url: `/eduService/coursefront/getCourseById/${courseId}`,
            method: 'get',
        })
    }
}