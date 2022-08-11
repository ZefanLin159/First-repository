package com.atguigu.eduorder.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduorder.service.TPayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/eduorder/paylog")
//@CrossOrigin
public class TPayLogController {
    @Autowired
    private TPayLogService payLogService;

    //    生成微信支付二维码
//    参数是订单号
    @GetMapping("createNative/{orderId}")
    public R createNative(@PathVariable("orderId") String orderId) {

//        返回相关信息，包含二维码地址，还有其他信息
        Map<String, Object> map = payLogService.createNative(orderId);
        System.out.println("二维码集合：" + map);
        return R.ok().data(map);
    }

    //    查询订单支付状态
    @GetMapping("queryPayStatus/{orderId}")
    public R queryPayStatus(@PathVariable("orderId") String orderId) {
        Map<String, String> map = payLogService.queryPayStatus(orderId);
        if (map == null) {
            return R.error().message("支付出错了");
        }
//        如果map不为空
        if (map.get("trade_state").equals("SUCCESS")) {
//            添加记录到支付表里面,更新订单表订单状态
            payLogService.updateOrdersStatus(map);
            return R.ok().message("支付成功");
        }
        return R.ok().code(25000).message("支付中");

    }
}

