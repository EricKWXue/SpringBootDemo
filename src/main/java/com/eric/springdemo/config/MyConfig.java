package com.eric.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取自定义配置
 */
@Configuration
@PropertySource("classpath:person-config.properties")
public class MyConfig {

    @Bean
    public MyConfigBean getConfigBeanOfMine(){
        return new MyConfigBean();
    }
}
