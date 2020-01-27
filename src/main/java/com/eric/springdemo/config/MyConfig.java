package com.eric.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebSocketConfig.class)
public class MyConfig {

    @Bean
    public MyConfigBean getConfigBeanOfMine(){
        return new MyConfigBean();
    }
}
