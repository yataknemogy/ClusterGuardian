package com.example.clusterguardian.controller;

import com.example.clusterguardian.service.ClusterNodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClusterNodeWebSocketTest {

    @LocalServerPort
    private int port;

    private WebSocketSession webSocketSession;

    private CompletableFuture<String> completableFuture;


    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);

        WebSocketClient webSocketClient = new StandardWebSocketClient();
        this.completableFuture = new CompletableFuture<>();

        this.webSocketSession = webSocketClient.doHandshake(new TextWebSocketHandler() {
            @Override
            protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
                completableFuture.complete(message.getPayload());
            }

            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                System.out.println("WebSocket connection established");
            }
        }, new WebSocketHttpHeaders(), URI.create("ws://localhost:" + port + "/ws/node-status")).get();
    }


    @Test
    public void testWebSocketMessageHandling() throws ExecutionException, InterruptedException, TimeoutException, IOException {
        String testMessage = "Test Status Update";

        webSocketSession.sendMessage(new TextMessage(testMessage));

        String receivedMessage = completableFuture.get(10, TimeUnit.SECONDS);

        assertEquals(testMessage, receivedMessage);
    }


}