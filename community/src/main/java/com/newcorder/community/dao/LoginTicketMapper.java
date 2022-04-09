package com.newcorder.community.dao;

import com.newcorder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
@Deprecated
public interface LoginTicketMapper {
    //    注解里也支持动态sql
    @Insert("insert into login_ticket (user_id, ticket, status, expired) values(#{userId},#{ticket},#{status},#{expired})")
    //sql配置，注入主键以及自增长
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select("select id,user_id,ticket,`status`,expired from login_ticket where ticket = #{ticket}")
    LoginTicket selectByTicket(String ticket);

    //        修改凭证状态,退出时凭证失效？
    @Update("update login_ticket SET status = #{status} where ticket = #{ticket}")
    int updateStatus(String ticket, int status);

}
