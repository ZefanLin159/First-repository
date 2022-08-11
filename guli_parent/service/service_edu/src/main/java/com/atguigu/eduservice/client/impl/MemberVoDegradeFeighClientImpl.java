package com.atguigu.eduservice.client.impl;

import com.atguigu.commonutils.vo.MemberVo;
import com.atguigu.eduservice.client.MemberVoClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class MemberVoDegradeFeighClientImpl implements MemberVoClient {

    @Override
    public MemberVo getMemberInfoById(@PathVariable("memberId") String memberId) {
        return null;
    }
}
