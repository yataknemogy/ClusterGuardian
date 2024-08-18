package com.example.clusterguardian.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class NodeStatusHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received message on server: " + message.getPayload());
        session.sendMessage(new TextMessage(message.getPayload()));
    }

    public void sendStatusUpdate(WebSocketSession session, String statusUpdate) throws IOException {
        session.sendMessage(new TextMessage(statusUpdate));
    }
}
