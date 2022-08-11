package com.atguigu.eduservice.client;

import com.atguigu.commonutils.vo.MemberVo;
import com.atguigu.eduservice.client.impl.MemberVoDegradeFeighClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "service-ucenter",fallback = MemberVoDegradeFeighClientImpl.class)
public interface MemberVoClient {
    @GetMapping("/eduucenter/member/getMemberInfoById/{memberId}")
    public MemberVo getMemberInfoById(@PathVariable String memberId);
}
