package com.eric.springdemo.service;

import com.eric.springdemo.domain.Person;

public interface AsyncService {
    void mailToAll(Person person);
}
