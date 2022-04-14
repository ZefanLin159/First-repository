package com.newcorder.community.enent;

import com.alibaba.fastjson.JSONObject;
import com.newcorder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    //    处理事件
    public void  fileEvent(Event event) {
//        将事件发布到指定的主题(传json字符串）
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }
}
