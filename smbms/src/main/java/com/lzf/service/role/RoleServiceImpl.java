package com.lzf.service.role;

import com.lzf.dao.BaseDao;
import com.lzf.dao.role.RoleDao;
import com.lzf.dao.role.RoleDaoImpl;
import com.lzf.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    public List<Role> getRoleList() {
        List<Role> roleList = new ArrayList<Role>();
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
             roleList = roleDao.getRoleList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }
//    @Test
//    public void test(){
//        RoleServiceImpl roleService = new RoleServiceImpl();
//        List<Role> roleList = roleService.getRoleList();
//        for (Role role : roleList) {
//            System.out.println(role.getId());
//        }
//    }

}
