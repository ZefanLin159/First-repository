import request from '@/utils/request'
export default {
    getListBanner() {
        return request({
            url: `/educms/bannerfront/findAllBanner`,
            method: 'get',
        })
    },
    index() {
        return request({
            url: `/eduService/indexfront/index`,
            method: 'get',
        })
    },
}