import request from '@/utils/request'

// 接口地址
// 1.讲师列表（条件查询带分页）
export default {
    getSubjectList() {
        return request({
            url: `/eduService/subject/getAllSubject`,
            method: 'get'
        })
    }
}
