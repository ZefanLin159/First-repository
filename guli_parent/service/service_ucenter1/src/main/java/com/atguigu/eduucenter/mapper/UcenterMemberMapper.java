package com.atguigu.eduucenter.mapper;

import com.atguigu.eduucenter.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author testJava
 * @since 2022-07-31
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {


    int registerCount(String date);
}
