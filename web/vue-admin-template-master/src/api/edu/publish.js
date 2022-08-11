import request from '@/utils/request'
export default {
getCoursePublishVo(courseId){
    return request({
        url: `/eduService/course/getCoursePublishInfo/${courseId}`,
        method: 'get',
    }) 
},
publishCourse(id){
    return request({
        url: `/eduService/course/publishCourse/${id}`,
        method: 'post',
    }) 
}
}