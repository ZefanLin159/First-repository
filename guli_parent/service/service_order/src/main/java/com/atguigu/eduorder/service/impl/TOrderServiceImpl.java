package com.atguigu.eduorder.service.impl;

import com.atguigu.commonutils.R;
import com.atguigu.commonutils.vo.CourseVoForOrder;
import com.atguigu.commonutils.vo.MemberVo;
import com.atguigu.eduorder.client.GetCourseClient;
import com.atguigu.eduorder.client.UcenterClient;
import com.atguigu.eduorder.entity.TOrder;
import com.atguigu.eduorder.mapper.TOrderMapper;
import com.atguigu.eduorder.service.TOrderService;
import com.atguigu.eduorder.util.OrderNoUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-08-07
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {


    @Autowired
    private GetCourseClient courseClient;

    @Autowired
    private UcenterClient ucenterClient;

    @Override
    public String createOrders(String courseId, String memberId) {
        CourseVoForOrder courseVo = courseClient.getCourseById(courseId);
        String cover = courseVo.getCover();
        String title = courseVo.getTitle();
        MemberVo memberVo = ucenterClient.getMemberInfoById(memberId);
        String nickname = memberVo.getNickname();
        String mobile = memberVo.getMobile();
        TOrder order = new TOrder();
        order.setMemberId(memberId);
        order.setMobile(mobile);
        order.setOrderNo(OrderNoUtils.getOrderNo());
        order.setNickname(nickname);
        order.setCourseId(courseId);
        order.setCourseTitle(title);
        order.setCourseCover(cover);
        order.setPayType(1);
        order.setStatus(0);
        baseMapper.insert(order);
        return order.getOrderNo();
    }
}
