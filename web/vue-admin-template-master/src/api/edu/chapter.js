import request from '@/utils/request'

// 接口地址
export default {
    getAllChapterVo(courseId) {
        return request({
            url: `/eduService/chapter/getChapterVideo/${courseId}`,
            method: 'get',
        })
    },
    getChapter(chapterId) {
        return request({
            url: `/eduService/chapter/getChapter/${chapterId}`,
            method: 'get',
        })
    },
    addChapter(eduChapter) {
        return request({
            url: `/eduService/chapter/addChapter`,
            method: 'post',
            data: eduChapter
        })
    },
    updateChapter(eduChapter) {
        return request({
            url: `/eduService/chapter/updateChapter`,
            method: 'post',
            data: eduChapter
        })
    },
    deleteChapter(chapterId) {
        return request({
            url: `/eduService/chapter/deleteChapter/${chapterId}`,
            method: 'delete',
        })
    },

}
