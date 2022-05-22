package com.newcorder.community.controller;

import com.newcorder.community.enent.EventProducer;
import com.newcorder.community.entity.Event;
import com.newcorder.community.entity.User;
import com.newcorder.community.service.LikeService;
import com.newcorder.community.util.CommunityConstant;
import com.newcorder.community.util.CommunityUtil;
import com.newcorder.community.util.HostHolder;
import com.newcorder.community.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LikeController implements CommunityConstant {
    @Autowired
    private LikeService likeService;

    @Autowired
    private EventProducer eventProducer;
    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(path = "/like", method = RequestMethod.POST)
    @ResponseBody
    public String like(int entityType, int entityId, int entityUserId, int postId) {
        User user = hostHolder.getUser();

//        点赞
        likeService.like(user.getId(), entityType, entityId, entityUserId);
//        数量
        long likeCount = likeService.findEntityLikeCount(entityType, entityId);
//        状态
        int likeStatus = likeService.findEntityStatus(user.getId(), entityType, entityId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("likeCount", likeCount);
        map.put("likeStatus", likeStatus);

//        触发点赞事件(取关不要给通知）
        if (likeStatus == 1) {
            Event event = new Event()
//                    这里 非常粗心，忘记设置userId了
                    .setUserId(hostHolder.getUser().getId())
                    .setTopic(TOPIC_LIKE)
                    .setEntityType(entityType)
                    .setEntityId(entityId)
                    .setEntityUserid(entityUserId)
                    .setData("postId", postId);
            eventProducer.fileEvent(event);


        }

        if (entityType == ENTITY_TYPE_POST) {

//        计算帖子分数
            String redisKey = RedisKeyUtil.getPostScoreKey();
            redisTemplate.opsForSet().add(redisKey, postId);
        }

        return CommunityUtil.getJSONString(0, null, map);
    }

}
