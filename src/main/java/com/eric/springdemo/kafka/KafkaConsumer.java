package com.eric.springdemo.kafka;


import com.eric.springdemo.handler.EchoWebSocketHandler;
import com.eric.springdemo.util.JsonUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="spring.kafka.customer.turn", havingValue = "on")
public class KafkaConsumer {

    @Autowired
    private EchoWebSocketHandler socketHandler;

    @KafkaListener(topics = "EricTopic", groupId = "eric")
    public void obtainMessage(ConsumerRecord<String, String> consumerRecord){
        System.out.println("KafkaConsumer.obtainMessage() start...");

        String topic = consumerRecord.topic();
        String key = consumerRecord.key();
        String value = consumerRecord.value();
        int partition = consumerRecord.partition();
        long timestamp = consumerRecord.timestamp();

        System.out.println("topic: " + topic);
        System.out.println("key: " + key);
        System.out.println("value: " + value);
        System.out.println("partition: " + partition);
        System.out.println("timestamp: " + timestamp);
        System.out.println("=========================");

        //向websocket推送消息
        String message = value;
        if(value.startsWith("{") || value.endsWith("}")){
            KafkaMessage kafkaMessage = JsonUtils.jsonToPojo(value, KafkaMessage.class);
            message = kafkaMessage.getMessageObj().toString();
        }
        socketHandler.sendMessage(message);

    }
}
