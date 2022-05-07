package com.newcorder.community.enent;

import com.alibaba.fastjson.JSONObject;
import com.newcorder.community.entity.DiscussPost;
import com.newcorder.community.entity.Event;
import com.newcorder.community.entity.Message;
import com.newcorder.community.service.DiscussPostService;
import com.newcorder.community.service.ElasticSearchService;
import com.newcorder.community.service.MessageService;
import com.newcorder.community.util.CommunityConstant;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class EventConsumer implements CommunityConstant {
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    //    被动触发的，加了这个注解就不需要调用了
    @KafkaListener(topics = {TOPIC_COMMENT, TOPIC_LIKE, TOPIC_FOLLOW})
    public void handleCommentMessage(ConsumerRecord record) {
        if (record == null || record.value() == null) {
            logger.error("消息内容为空");
            return;
        }

        Event event = JSONObject.parseObject(record.value().toString(), Event.class);
        if (event == null) {
            logger.error("消息格式错误！");
            return;
        }

//      发送站内通知
        Message message = new Message();
        message.setFromId(SYSTEM_USER_ID);
        message.setToId(event.getEntityUserid());
        message.setConversationId(event.getTopic());
        message.setCreateTime(new Date());

        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("userId", event.getUserId());
        contentMap.put("entityType", event.getEntityType());
        contentMap.put("entityId", event.getEntityId());
        if (!event.getData().isEmpty()) {
            for (Map.Entry<String, Object> entry : event.getData().entrySet()) {
                contentMap.put(entry.getKey(), entry.getValue());
            }
        }
        message.setContent(JSONObject.toJSONString(contentMap));
//        添加系统消息进数据库
        messageService.addMessage(message);
    }

    //    消费发帖事件
    @KafkaListener(topics = (TOPIC_PUBLISH))
    public void handlerPublishMessage(ConsumerRecord record) {

        if (record == null || record.value() == null) {
            logger.error("消息内容为空");
            return;
        }

        Event event = JSONObject.parseObject(record.value().toString(), Event.class);
        if (event == null) {
            logger.error("消息格式错误！");
            return;
        }

        DiscussPost post = discussPostService.findDiscussPost(event.getEntityId());
        elasticSearchService.saveDisscussPost(post);

    }
}
