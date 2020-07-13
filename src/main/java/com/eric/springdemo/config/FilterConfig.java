package com.eric.springdemo.config;

import com.eric.springdemo.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册filter过滤器
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> characterFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CharacterEncodingFilter());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("encoding", "utf-8");
        filterRegistrationBean.setInitParameters(initParameters);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("characterFilter");
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> xssFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("xssFilter");
        filterRegistrationBean.setOrder(11);
        return filterRegistrationBean;
    }

}
