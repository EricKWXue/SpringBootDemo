package com.eric.springdemo.kafka;

import com.eric.springdemo.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="spring.kafka.customer.turn", havingValue = "on")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendKafkaMessage(KafkaMessage message){
        this.kafkaTemplate.send("EricTopic", JsonUtils.objectToJson(message));
    }
}
