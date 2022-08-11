package com.atguigu.aclservice.controller;


import com.atguigu.aclservice.entity.AclPermission;
import com.atguigu.aclservice.service.AclPermissionService;
import com.atguigu.commonutils.R;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-08-09
 */
@RestController
@RequestMapping("/aclservice/permission")
public class AclPermissionController {

    @Autowired
    private AclPermissionService permissionService;

    @ApiModelProperty(name = "查询所有菜单")
    @GetMapping("getAllIndex")
    public R getAllIndex() {
        List<AclPermission> list = permissionService.queryAllMenu();
        return R.ok().data("list", list);
    }

    @ApiModelProperty(name = "删除菜单（指定节点）")
    @DeleteMapping("deleteIndex/{id}")
    public R deleteIndex(@PathVariable("id") String id) {
        permissionService.deleteChildById(id);
        return R.ok();
    }

    @ApiModelProperty(name = "给角色分配菜单")
    @PostMapping("doAssign")
    public R doAssign(String roleId, String[] permissionIds) {
        permissionService.saveRolePermissionRelation(roleId,permissionIds);
        return R.ok();
    }
}

