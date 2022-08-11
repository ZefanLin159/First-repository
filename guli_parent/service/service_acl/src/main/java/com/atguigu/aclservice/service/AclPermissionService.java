package com.atguigu.aclservice.service;

import com.atguigu.aclservice.entity.AclPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author testJava
 * @since 2022-08-09
 */
public interface AclPermissionService extends IService<AclPermission> {

    List<AclPermission> queryAllMenu();

    void deleteChildById(String id);

    void saveRolePermissionRelation(String roleId, String[] permissionIds);
}
