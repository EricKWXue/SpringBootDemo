package com.eric.springdemo.service;

public class DefaultEchoServiceImpl implements EchoService {

    private final String msgFormat;

    public DefaultEchoServiceImpl(){
        this.msgFormat = "%s";
    }

    public DefaultEchoServiceImpl(String msgFormat){
        this.msgFormat = null != msgFormat ? msgFormat : "%s";
    }

    @Override
    public String getMessage(String message) {
        return String.format(this.msgFormat, message);
    }
}
