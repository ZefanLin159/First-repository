package com.atguigu.eduorder.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.eduorder.entity.TOrder;
import com.atguigu.eduorder.service.TOrderService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/eduorder/order")
@CrossOrigin
public class TOrderController {
    @Autowired
    private TOrderService orderService;

    //    生成订单的方法
    @PostMapping("createOrder/{courseId}")
    public R createOrder(@PathVariable("courseId") String courseId, HttpServletRequest request) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if (memberId == null) throw new GuliException(20001, "请登录");
        String orderNo = orderService.createOrders(courseId, memberId);
        return R.ok().data("orderId", orderNo);
    }

    //    根据订单id查询订单信息
    @GetMapping("getOrderInfo/{orderId}")
    public R getOrderInfo(@PathVariable("orderId") String orderId) {
        QueryWrapper<TOrder> tOrderQueryWrapper = new QueryWrapper<>();
//        这个订单id不是主键id
        tOrderQueryWrapper.eq("order_no", orderId);
        TOrder order = orderService.getOne(tOrderQueryWrapper);

        return R.ok().data("order", order);
    }

    //    根据课程id查询订单status状态是否已经购买过
    @GetMapping("getBuyStatus/{courseId}")
    public R getBuyStatus(@PathVariable("courseId") String courseId, HttpServletRequest request) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if (memberId == null) throw new GuliException(20001, "请登录");
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        queryWrapper.eq("member_id", memberId);
        queryWrapper.eq("status", 1);
        int count = orderService.count(queryWrapper);
        return R.ok().data("count", count);

    }
}

