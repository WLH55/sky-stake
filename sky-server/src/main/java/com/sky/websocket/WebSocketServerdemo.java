package com.sky.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * WebSocket服务
 */
@Component
@ServerEndpoint("/websocket")
public class WebSocketServerdemo {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());


    @OnOpen
    public void onOpen(Session session){
        System.out.println("onOpen"  + session.getId());
    }

    @OnMessage
    public void onMessage(Session session,String message) throws IOException {
        System.out.println("received message " + message);
        session.getBasicRemote().sendText("我已收到客户端发送的消息:" + message);
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection closed: " + session.getId());
        sessions.remove(session);
    }




}