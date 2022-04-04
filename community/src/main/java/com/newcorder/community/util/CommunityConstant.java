package com.newcorder.community.util;

public interface CommunityConstant {
    /*激活状态*/
    //    激活成功
    int ACTIVATION_SUCCESS = 0;
    //    重复激活
    int ACTIVATION_REPEAT = 1;
    //    激活失败
    int ACTIVATION_FAIL = 2;
    /*
    默认状态的登录凭证的超时时间
    */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 30;

    /*
     * 实体类型：帖子*/
    int ENTITY_TYPE_POST = 1;
    /*实体类型：评论*/
    int ENTYTY_TYPE_COMMENT = 2;
}
