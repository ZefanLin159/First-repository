import request from '@/utils/request'
export default {
    login(member) {
        return request({
            url: `/eduucenter/member/login`,
            method: 'post',
            data:member
        })
    },
    getMemberInfo(){
        return request({
            
            url: `/eduucenter/member/getMemberInfo`,
            method: 'get',
        })
    }
}