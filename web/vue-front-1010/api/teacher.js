import request from '@/utils/request'
export default {
    getTeacherFrontList(page,limit) {
        return request({
            url: `/eduService/teacherfront/getTeacherFrontList/${page}/${limit}`,
            method: 'get',
        })
    },
    getTeacherById(id){
        return request({
            url: `/eduService/teacherfront/getTeacherById/${id}`,
            method: 'get',
        })
    },
    getCourseById(teacherId){
        return request({
            url: `/eduService/teacherfront/getCourseById/${teacherId}`,
            method: 'get',
        })
    }
}