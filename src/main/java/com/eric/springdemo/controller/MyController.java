package com.eric.springdemo.controller;

import com.eric.springdemo.config.MyConfigBean;
import com.eric.springdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eric")
public class MyController {

    @Autowired
    private MyConfigBean config;

    @RequestMapping(value = "/person")
    public Person getPerson() {
        return new Person(config.getMyId(), config.getMyName(), config.getMyGender());
    }
}
