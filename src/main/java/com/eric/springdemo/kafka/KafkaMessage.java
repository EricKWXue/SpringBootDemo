package com.eric.springdemo.kafka;

import java.util.Date;

public class KafkaMessage {
    private long id;

    private Object MessageObj;

    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getMessageObj() {
        return MessageObj;
    }

    public void setMessageObj(Object messageObj) {
        MessageObj = messageObj;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
