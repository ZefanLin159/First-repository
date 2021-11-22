package com.lzf.dao;

import com.lzf.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

//    注解有局限性，最好还是用xml来解决
    @Select("select * from user")
    List<User> getUser();

//    方法存在多个参数，所有的参数前面必须加上@Param注解，就是给#{id}
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id")int id);

//    #{}要和User的变量名一致
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{passwords})")
    int addUser(User user);

    @Update("update user set name = #{name},pwd = #{passwords} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
