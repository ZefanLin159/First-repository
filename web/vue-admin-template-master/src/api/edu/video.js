import request from '@/utils/request'

// 接口地址
export default {
    addVideo(eduVideo) {
        return request({
            url: `/eduService/video/addVideo`,
            method: 'post',
            data: eduVideo
        })
    },
    getVideo(videoId) {
        return request({
            url: `/eduService/video/getVideo/${videoId}`,
            method: 'get',
        })
    },
    // 修改小节 
    updateVideo(eduVideo){
        return request({
            url: `/eduService/video/updateVideo/${eduVideo.id}`,
            method: 'post',
            data: eduVideo
        })
    },
    // 删除小节 
    deleteVideo(videoId){
        return request({
            url: `/eduService/video/deleteVideo/${videoId}`,
            method: 'delete'
        })
    },
    deleteVideoAli(videoId){
        return request({
            url: `/eduvod/video/deleteVideoAli/${videoId}`,
            method: 'delete'
        }) 
    }
}
