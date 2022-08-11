import request from '@/utils/request'
export default {
    createOrder(courseId) {
        return request({
            url: `/eduorder/order/createOrder/${courseId}`,
            method: 'post',
        })
    },
    getOrderInfo(orderId){
        return request({
            url: `/eduorder/order/getOrderInfo/${orderId}`,
            method: 'get',
        })
    },
    // 生成二维码 
    createNative(orderId){
        return request({
            url: `/eduorder/paylog/createNative/${orderId}`,
            method: 'get',
        })  
    },

    // 查询订单状态方法
    queryPayStatus(orderId){
        return request({
            url: `/eduorder/paylog/queryPayStatus/${orderId}`,
            method: 'get',
        })  
    },
    getBuyStatus(courseId){
        return request({
            url: `/eduorder/order/getBuyStatus/${courseId}`,
            method: 'get',
        })     
    }
}