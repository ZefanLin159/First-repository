import request from '@/utils/request'

// 接口地址
export default {
    registerCount(date) {
        return request({
            url: `/statistics/daily/registerCount/${date}`,
            method: 'post',
        })
    },
    showData(searchObj){
        return request({
            url: `/statistics/daily/showData/${searchObj.type}/${searchObj.begin}/${searchObj.end}`,
            method: 'get',
        })

    }
}