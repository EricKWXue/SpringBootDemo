package com.eric.springdemo.controller;

import com.eric.springdemo.config.MyConfigBean;
import com.eric.springdemo.domain.Person;
import com.eric.springdemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eric")
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/person")
    public Person getPerson() {
        return myService.findAllPerson();
    }
}
