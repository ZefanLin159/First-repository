import request from '@/utils/request'
export default {
    send(phoneNum) {
        return request({
            url: `/edumsm/msm/send/${phoneNum}`,
            method: 'get',
        })
    },
    register(registerVo) {
        return request({
            url: `/eduucenter/member/register`,
            method: 'post',
            data:registerVo
        })
    },
}