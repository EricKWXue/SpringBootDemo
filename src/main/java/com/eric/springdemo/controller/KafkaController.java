package com.eric.springdemo.controller;

import com.eric.springdemo.kafka.KafkaMessage;
import com.eric.springdemo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/kafka", produces = MediaType.APPLICATION_JSON_VALUE)
@ConditionalOnProperty(name="spring.kafka.customer.turn", havingValue = "on")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public KafkaMessage sendKafkaMessage(@RequestParam(name = "messageObj") String message){
        System.out.println("sendKafkaMessage invoked...");

        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(1);
        kafkaMessage.setMessageObj(message);
        kafkaMessage.setDate(new Date());

        this.kafkaProducer.sendKafkaMessage(kafkaMessage);
        return kafkaMessage;
    }
}
