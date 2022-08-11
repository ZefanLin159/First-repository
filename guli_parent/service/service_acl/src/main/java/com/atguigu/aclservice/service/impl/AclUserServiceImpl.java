package com.atguigu.aclservice.service.impl;

import com.atguigu.aclservice.entity.AclUser;
import com.atguigu.aclservice.mapper.AclUserMapper;
import com.atguigu.aclservice.service.AclUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-08-09
 */
@Service
public class AclUserServiceImpl extends ServiceImpl<AclUserMapper, AclUser> implements AclUserService {

}
