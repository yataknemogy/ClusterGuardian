package com.example.clusterguardian;

import com.example.clusterguardian.handler.NodeStatusHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final NodeStatusHandler nodeStatusHandler;

    public WebSocketConfig(NodeStatusHandler nodeStatusHandler) {
        this.nodeStatusHandler = nodeStatusHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(nodeStatusHandler, "/ws/node-status").setAllowedOrigins("*");
    }
}