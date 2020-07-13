package com.eric.springdemo.service;

import com.eric.springdemo.domain.Person;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("threadPoolExecutor")
    public void mailToAll(Person person) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("通知下去，这个人" + person.getName() + "我要了!");
    }
}
