package com.eric.springdemo.config;

import com.eric.springdemo.handler.EchoWebSocketHandler;
import com.eric.springdemo.interceptor.EchoHandShakeInterceptor;
import com.eric.springdemo.service.DefaultEchoServiceImpl;
import com.eric.springdemo.service.EchoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getWebSocketHandler(), "/echo").addInterceptors(getInterceptor()).withSockJS();
    }

    @Bean
    public EchoWebSocketHandler getWebSocketHandler(){
        return new EchoWebSocketHandler(getEchoService());
    }

    @Bean
    public EchoService getEchoService(){
        return new DefaultEchoServiceImpl("you said \"%s\"!");
    }

    @Bean
    public HandshakeInterceptor getInterceptor(){
        return new EchoHandShakeInterceptor();
    }

}
