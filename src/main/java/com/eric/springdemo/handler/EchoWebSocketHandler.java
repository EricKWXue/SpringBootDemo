package com.eric.springdemo.handler;

import com.eric.springdemo.service.EchoService;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EchoWebSocketHandler extends TextWebSocketHandler {

    private static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    private EchoService echoService;

    public EchoWebSocketHandler(EchoService echoService){
        this.echoService = echoService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession wsSession) throws Exception {
        System.out.println("websocket connected");
        sessionMap.put(wsSession.getId(), wsSession);
    }

    @Override
    public void handleTextMessage(WebSocketSession wsSession, TextMessage message) throws Exception {
        String echoMessage = this.echoService.getMessage(message.getPayload());
        wsSession.sendMessage(new TextMessage(echoMessage));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession wsSession, CloseStatus status) throws Exception {
        System.out.println("websocket closed");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("websocket error");
        session.close(CloseStatus.SERVER_ERROR);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message){
        sessionMap.forEach((id, session) -> {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
