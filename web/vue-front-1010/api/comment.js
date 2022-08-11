import request from '@/utils/request'
export default {
    getComment(page,limit,courseId) {
        return request({
            url: `/eduservice/comment/getComment/${page}/${limit}`,
            method: 'get',
            params:courseId
        })
    },
    addComment(comment) {
        return request({
            url: `/eduservice/comment/auth/addComment`,
            method: 'post',
            data:comment
        })
    },
}