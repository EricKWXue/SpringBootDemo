package com.eric.springdemo.config;

import org.springframework.beans.factory.annotation.Value;

public class MyConfigBean {

    @Value("${myconfig.myperson.myid}")
    private Integer myId;

    @Value("${myconfig.myperson.myname}")
    private String myName;

    @Value("${myconfig.myperson.mygender}")
    private String myGender;

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyGender() {
        return myGender;
    }

    public void setMyGender(String myGender) {
        this.myGender = myGender;
    }
}
