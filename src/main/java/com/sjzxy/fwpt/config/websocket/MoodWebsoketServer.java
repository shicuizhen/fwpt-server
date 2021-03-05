package com.sjzxy.fwpt.config.websocket;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Log4j2
@ServerEndpoint("/mood/{uid}")
public class MoodWebsoketServer {
//    ws://127.0.0.1:8180/webSocket/{uid}


    /**
     * 记录当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 存放客户端对应的WebSocketServer对象
     */
    private static ConcurrentHashMap<String, MoodWebsoketServer> webSocketServerMap = new ConcurrentHashMap<>();

    /**
     * 同客户端的连接会话，给客户端发送数据
     */
    private Session session;

    /**
     * 用户id
     */
    private String uid;


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) throws InterruptedException {
        this.session = session;
        this.uid = uid;
        Thread.sleep(4000);
        webSocketServerMap.put(uid, this);
        onlineCount.incrementAndGet();
        log.info("---> WebSocket, 客户端[{}]连接成功，当前在线人数为：{}", uid, onlineCount.get());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws InterruptedException {
        webSocketServerMap.remove(uid);
        onlineCount.decrementAndGet();
        log.info("---> WebSocket, 客户端[{}]断开连接，当前在线人数为：{}", uid, onlineCount.get());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("---> WebSocket, 客户端消息", message);
    }


    @OnError
    public void onError(Throwable error) {
        log.error("---> WebSocket,客户端[{}]异常", this.uid);
        error.printStackTrace();
    }




    public void sendInfo(String message) {

        try {
            for (MoodWebsoketServer webSocketServer : webSocketServerMap.values()){
//                webSocketServer.session.getBasicRemote().sendText(message);
                webSocketServer.session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            log.error("---> WebSocket, 向客户端[{}]发送消息异常", this.uid);
            e.printStackTrace();
        }
    }

}



