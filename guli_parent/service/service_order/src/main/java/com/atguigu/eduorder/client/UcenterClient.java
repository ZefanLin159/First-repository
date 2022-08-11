package com.atguigu.eduorder.client;

import com.atguigu.commonutils.vo.MemberVo;
import com.atguigu.eduorder.client.impl.UcenterClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "service-ucenter",fallback = UcenterClientImpl.class)
public interface UcenterClient {
    @GetMapping("/eduucenter/member/getMemberInfoById/{memberId}")
    public MemberVo getMemberInfoById(@PathVariable String memberId);
}
