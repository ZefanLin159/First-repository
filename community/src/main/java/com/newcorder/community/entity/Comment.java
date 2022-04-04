package com.newcorder.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private int userId;
    private int entityType; //1 代表帖子，2 代表评论 3代表用户……
    private int entityId; // 这个类型的目标
    private int targetId; //对应回复指向人的id
    private String content;
    private int status;
    private Date createTime;
}
