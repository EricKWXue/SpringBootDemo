package com.eric.springdemo.service;

import com.eric.springdemo.config.MyConfigBean;
import com.eric.springdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private MyConfigBean config;

    @Override
    public Person findAllPerson() {
        Person person = new Person(config.getMyId(), config.getMyName(), config.getMyGender());
        asyncService.mailToAll(person);

        System.out.println("找到了这个人" + person.getName() +"了！");
        return person;
    }
}
