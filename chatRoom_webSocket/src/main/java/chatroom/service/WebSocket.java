package chatroom.service;

import chatroom.entity.Message2Client;
import chatroom.entity.MessageFromClient;
import chatroom.utils.CommUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有连接到后端的webSocket
    private static CopyOnWriteArraySet<WebSocket> clients =
            new CopyOnWriteArraySet<>();
    //绑定当前webSocket会话
    private Session session;
    //缓存所有用户的列表
    private static Map<String, String> names = new ConcurrentHashMap<>();
    //当前客户端的用户名
    private String userName;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        String userName = session.getQueryString().split("=")[1];
        this.userName = userName;
        clients.add(this);
        names.put(session.getId(), userName);
        System.out.println("有新的连接，当前SessionId为：" + session.getId()
                + "，当前微聊用户为：" + userName);
        //发送给所有在线户的一个上线通知
        Message2Client message2Client = new Message2Client();
        message2Client.setContent(userName + "上线了！");
        message2Client.setNames(names);
        //发送消息
        String jsonStr = CommUtils.object2Json(message2Client);
        for (WebSocket webSocket : clients) {
            webSocket.sendMsg(jsonStr);
        }
    }

    @OnError
    public void onError(Throwable e) {
        System.err.println("webSocket连接失败！");
    }

    //群聊:{"msg":"777","type":1}
    //私聊:{"to":"0-","msg":"33333","type":2}
    @OnMessage
    public void onMessage(String msg) {
        MessageFromClient messageFromClient = (MessageFromClient) CommUtils.json2Object(msg, MessageFromClient.class);
        if (messageFromClient.getType().equals("1")) {
            //群聊
            String content = messageFromClient.getMsg();
            Message2Client message2Client = new Message2Client();
            message2Client.setContent(content);
            message2Client.setNames(names);
            for (WebSocket webSocket : clients) {
                webSocket.sendMsg(CommUtils.object2Json(message2Client));
            }
        } else if (messageFromClient.getType().equals("2")) {
            //私聊
            String content = messageFromClient.getMsg();
            int toL = messageFromClient.getTo().length();
            String tos[] = messageFromClient.getTo()
                    .substring(0, toL - 1).split("-");
            List<String> lists = Arrays.asList(tos);
            //给指定SessionID发送信息
            for (WebSocket webSocket : clients) {
                if (lists.contains(webSocket.session.getId()) &&
                        this.session.getId() != webSocket.session.getId()) {
                    // 发送私聊信息
                    Message2Client message2Client = new Message2Client();
                    message2Client.setContent(userName, content);
                    message2Client.setNames(names);
                    webSocket.sendMsg(CommUtils.object2Json(message2Client));
                }
            }
        }
    }

    @OnClose
    public void onClose() {
        // 将客户端聊天实体移除
        clients.remove(this);
        // 将当前用户以及SessionID保存到用户列表
        names.remove(session.getId());
        System.out.println("有连接下线了" +
                ",用户名为" + userName);
        // 发送给所有在线用户一个下线通知
        Message2Client message2Client = new Message2Client();
        message2Client.setContent(userName + "下线了!");
        message2Client.setNames(names);
        // 发送信息
        String jsonStr = CommUtils.object2Json(message2Client);
        for (WebSocket webSocket : clients) {
            webSocket.sendMsg(jsonStr);
        }
    }

    public void sendMsg(String msg) {
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
