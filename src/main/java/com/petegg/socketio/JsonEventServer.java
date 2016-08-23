package com.petegg.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.MultiTypeArgs;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.MultiTypeEventListener;

/**
 * <p>
 * Title: JsonLauncher
 * </p>
 * <p>
 * Description: com.corundumstudio.socketio.demo
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月23日
 */
public class JsonEventServer {
  private static Logger log = LoggerFactory.getLogger(JsonEventServer.class);

  public static void main(String[] args) {
    Configuration config = new Configuration();
    config.setHostname("localhost");
    config.setPort(9092);

    final SocketIOServer server = new SocketIOServer(config);
    
    //监听连接事件
    server.addConnectListener(new ConnectListener() {

      @Override
      public void onConnect(SocketIOClient client) {
        JsonEventServer.log.info("检测到connect, sessionID={}", client.getSessionId().toString());
      }
    });

    //监听数据事件
    server.addEventListener("jsonevent", EventObject.class, new DataListener<EventObject>() {

      @Override
      public void onData(SocketIOClient client, EventObject data, AckRequest ackSender)
          throws Exception {
        JsonEventServer.log.info("发生jsonevent事件,并且获得的数据 [{}]", JSONObject.toJSONString(data));
        server.getBroadcastOperations().sendEvent("jsonevent", JSONObject.toJSONString(data));
      }

    });
    
    server.addMultiTypeEventListener("jsonevent", new MultiTypeEventListener(){

      @Override
      public void onData(SocketIOClient client, MultiTypeArgs data, AckRequest ackSender)
          throws Exception {
        // TODO Auto-generated method stub
        JsonEventServer.log.info("发生jsonevent事件,并且获得的数据 [{}]", JSONObject.toJSONString(data));
      }

      
      
    }, EventObject.class);
    
    //开启服务
    server.start();
  }
}
