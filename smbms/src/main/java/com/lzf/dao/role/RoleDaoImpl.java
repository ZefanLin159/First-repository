package com.lzf.dao.role;

import com.lzf.dao.BaseDao;
import com.lzf.pojo.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    //    获取角色列表
    public List<Role> getRoleList(Connection connection) throws SQLException {
        List<Role> list = new ArrayList<Role>();
        if (connection != null) {
            String sql = "select * from smbms_role";
            Object[] params = {};
            ResultSet rs = BaseDao.executeC(connection, sql, params);
            while (rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("roleName"));
                role.setRoleCode(rs.getString("roleCode"));
                list.add(role);
            }
//            connection在service层关闭
            BaseDao.closeResource(null,null,rs);
        }
        return list;
    }
}
