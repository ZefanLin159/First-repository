import request from '@/utils/request'

// 接口地址
// 1.讲师列表（条件查询带分页）
export default {
    getTeacherListPage(current, limit, teacherQuery) {
        return request({
            url: `eduService/teacher/pageTeacherCondition/${current}/${limit}`,
            method: 'post',
            // teacherQuerytiaoj条件对象，后端使用RequestBody获取数据
            // data标识把对象转换json传递到接口里面
            data: teacherQuery
        })
    },
    deleteTeacherId(id) {
        return request({
            url: `eduService/teacher/remove/${id}`,
            method: 'delete'
        })
    },
    addTeacher(teacher) {
        return request({
            url: `eduService/teacher/addTeacher`,
            method: 'post',
            // data可以让teacher自动转化成json
            data: teacher
        })
    },
    getTeacherInfo(id) {
        return request({
            url: `eduService/teacher/getTeacher/${id}`,
            method: 'get'
        })
    },
    updateTeacherInfo(teacher) {
        return request({
            // url: '/table/list',
            url: `eduService/teacher/updateTeacher`,
            method: 'post',
            data: teacher
        })
    }
}
