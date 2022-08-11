package com.atguigu.aclservice.service.impl;

import com.atguigu.aclservice.entity.AclPermission;
import com.atguigu.aclservice.entity.AclRolePermission;
import com.atguigu.aclservice.mapper.AclPermissionMapper;
import com.atguigu.aclservice.service.AclPermissionService;
import com.atguigu.aclservice.service.AclRolePermissionService;
import com.atguigu.aclservice.service.AclRoleService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-08-09
 */
@Service
public class AclPermissionServiceImpl extends ServiceImpl<AclPermissionMapper, AclPermission> implements AclPermissionService {

    @Autowired
    private AclRolePermissionService rolePermissionService;

    @Override
    public List<AclPermission> queryAllMenu() {
        QueryWrapper<AclPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("gmt_create");
        List<AclPermission> list = baseMapper.selectList(queryWrapper);
//        把所有菜单list集合按照要求封装
        return this.buildPermission(list);
    }

    @Override
    @Transactional
    public void deleteChildById(String id) {
        AclPermission aclPermission = baseMapper.selectById(id);
        if (aclPermission == null) throw new GuliException(20001, "id不存在");

        List<String> idList = new ArrayList<>();
//        向idList集合设置删除菜单id
        this.selectPermissionChildById(id, idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
    }

    @Override
    public void saveRolePermissionRelation(String roleId, String[] permissionIds) {
        List<AclRolePermission> rolePermissionList = new ArrayList<>();
        for (String pid : permissionIds) {
            AclRolePermission rolePermission = new AclRolePermission();
            rolePermission.setId(roleId);
            rolePermission.setPermissionId(pid);
            rolePermissionList.add(rolePermission);
        }
        rolePermissionService.saveBatch(rolePermissionList);
    }

    private void selectPermissionChildById(String id, List<String> idList) {
        QueryWrapper<AclPermission> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", id);
        wrapper.select("id");
        List<AclPermission> childIdList = baseMapper.selectList(wrapper);

//        把childrenList中的菜单id值去除，封装到idList里面，做递归查询
        childIdList.stream().forEach(item -> {
//            封装idList
            idList.add(item.getId());
//            递归查询
            this.selectPermissionChildById(item.getId(), idList);
        });
    }


    private List<AclPermission> buildPermission(List<AclPermission> permissionList) {
//        创建list集合，用于最终封装
        List<AclPermission> finalNode = new ArrayList<>();
        for (AclPermission node : permissionList) {
            if ("0".equals(node.getPid())) {
                node.setLevel(1);
                finalNode.add(this.selectChildren(node, permissionList));
                break;
            }
        }
        return finalNode;
    }

    private AclPermission selectChildren(AclPermission node, List<AclPermission> permissionList) {

        node.setChildren(new ArrayList<AclPermission>());
        for (AclPermission childNode : permissionList) {
            if (node.getId().equals(childNode.getPid())) {
                int level = node.getLevel() + 1;
                childNode.setLevel(level);
                node.getChildren().add(this.selectChildren(childNode, permissionList));
            }
        }
        return node;
    }
}
