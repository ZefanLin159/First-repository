package com.atguigu.eduucenter.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.eduucenter.entity.UcenterMember;
import com.atguigu.commonutils.vo.MemberVo;
import com.atguigu.eduucenter.entity.vo.RegisterVo;
import com.atguigu.eduucenter.service.UcenterMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.sql.Date;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-07-31
 */
@RestController
@RequestMapping("/eduucenter/member")
//@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    //    登录功能(单点登录）RequestBody不能用getmapping
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
//        调用service方法实现登录
//        返回token值，使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token", token);
    }
//    注册功能

    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

    //    根据token获取用户信息
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo", member);
    }

    //    根据用户id获取用户信息
    @GetMapping("getMemberInfoById/{memberId}")
    public MemberVo getMemberInfoById(@PathVariable("memberId") String memberId) {
        UcenterMember member = memberService.getById(memberId);
        MemberVo memberVo = new MemberVo();
        BeanUtils.copyProperties(member, memberVo);
        return memberVo;
    }

    @GetMapping("getRegisterCount/{date}")
    public int getRegisterCount(@PathVariable("date") String date) {

        return memberService.registerCount(date);
    }
}

