package com.eric.springdemo.kafka;

import com.eric.springdemo.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendKafkaMessage(KafkaMessage message){
        this.kafkaTemplate.send("EricTopic", JsonUtils.objectToJson(message));
    }
}
