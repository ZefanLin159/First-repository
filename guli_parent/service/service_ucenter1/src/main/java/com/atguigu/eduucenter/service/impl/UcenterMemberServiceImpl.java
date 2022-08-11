package com.atguigu.eduucenter.service.impl;

import com.alibaba.nacos.common.util.Md5Utils;
import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5;
import com.atguigu.eduucenter.entity.UcenterMember;
import com.atguigu.eduucenter.entity.vo.RegisterVo;
import com.atguigu.eduucenter.mapper.UcenterMemberMapper;
import com.atguigu.eduucenter.service.UcenterMemberService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-07-31
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(UcenterMember member) {
//        获取手机号和登录密码（member传过来的是手机和密码）
        String mobile = member.getMobile();
        String password = member.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new GuliException(20001, "登录失败");
        }

//        判断手机号是否正确
        if (mobile.length() != 11) {
            throw new GuliException(20001, "手机格式不正确");
        }
        QueryWrapper<UcenterMember> memberWrapper = new QueryWrapper<>();
        memberWrapper.eq("mobile", mobile);
        UcenterMember mobileMember = baseMapper.selectOne(memberWrapper);
        if (mobileMember == null) {
            throw new GuliException(20001, "用户不存在");
        }
//        判断密码
        String test1 = MD5.encrypt("111111");
        String encrypt = MD5.encrypt(password);
        if (!mobileMember.getPassword().equals(MD5.encrypt(password))) {
            throw new GuliException(20001, "密码不正确");
        }
//        判断用户是否被禁用
        if (mobileMember.getIsDisabled()) {
            throw new GuliException(20001, "用户异常");
        }
//        登录成功，返回token
        return JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

    }

    @Override
    public void register(RegisterVo registerVo) {

        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
        String nickname = registerVo.getNickname();
        String verification = registerVo.getVerification();

        if (StringUtils.isEmpty(mobile)) {
            throw new GuliException(20001, "手机号不能为空");
        }

        if (StringUtils.isEmpty(password)) {
            throw new GuliException(20001, "密码不能为空");
        }
        if (StringUtils.isEmpty(nickname)) {
            throw new GuliException(20001, "昵称不能为空");
        }

        if (StringUtils.isEmpty(verification)) {
            throw new GuliException(20001, "验证码不能为空");
        }

        if (mobile.length() < 11) {
            throw new GuliException(20001, "手机格式不正确"); //前端也可加入校验
        }
//        判断验证码（先从redis中获取）
        String redisVerification = redisTemplate.opsForValue().get(mobile);
        if (redisVerification == null || !redisVerification.equals(verification)) {
            throw new GuliException(20001, "验证码不正确"); //前端也可加入校验
        }
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        int count = baseMapper.selectCount(wrapper);
        if (count > 0) {
            throw new GuliException(20001, "用户已存在");
        }
        UcenterMember ucenterMember = new UcenterMember();
        ucenterMember.setMobile(mobile);
        ucenterMember.setPassword(MD5.encrypt(password));
        ucenterMember.setNickname(nickname);
        ucenterMember.setIsDisabled(false);
        ucenterMember.setAvatar("https://ss2.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1596948543,4027947044&fm=253&gp=0.jpg");
        baseMapper.insert(ucenterMember);


    }

    @Override
    public UcenterMember getOpenIdMember(String open_id) {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",open_id);
        UcenterMember member = baseMapper.selectOne(wrapper);
        return member;
    }

    @Override
    public int registerCount(String date) {
        return baseMapper.registerCount(date);
    }
}

