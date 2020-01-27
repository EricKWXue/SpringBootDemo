package com.eric.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringdemoApplication {

    private final Logger logger = LoggerFactory.getLogger(SpringdemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @PostConstruct
    public void pringLog(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
