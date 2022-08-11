import request from '@/utils/request'
export default {
    getVideoTicket(videoSourceId) {
        return request({
            url: `/eduvod/video/getVideoTicket/${videoSourceId}`,
            method: 'get',
        })
    },
}