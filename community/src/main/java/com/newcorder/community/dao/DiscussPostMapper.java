package com.newcorder.community.dao;

import com.newcorder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //    动态sql，可以不使用userId
//    offset 每一页起始行行号
//    limitPage 每一页最多显示多少数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limitPage);

    //    需要动态拼接时，如果该方法只有一个参数时，我们必须加别名，否则报错
    // @Param用于给参数取别名
    // 如果只有一个参数，并且在<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);


    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);

}
