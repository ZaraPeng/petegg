package com.petegg.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.petegg.socketio.request.WashRequest;

/**
 * <p>
 * Title: 宠物洗澡事件
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
@Component
public class WashEventServer {
  private static Logger log = LoggerFactory.getLogger(WashEventServer.class);
  
  public void start() {
    Configuration config = new Configuration();
    config.setHostname("localhost");
    config.setPort(9092);

    final SocketIOServer server = new SocketIOServer(config);

    // 监听数据事件
    server.addEventListener("washEvent", WashRequest.class, new DataListener<WashRequest>() {

      @Override
      public void onData(SocketIOClient client, WashRequest data, AckRequest ackSender)
          throws Exception {
        WashEventServer.log.info("client[{}] 发送数据 [{}]", client.getSessionId(),
            JSONObject.toJSONString(data));

        //业务处理
        
        
        // 发送给单独客服端
        server.getClient(client.getSessionId()).sendEvent("washEvent",
            JSONObject.toJSONString(data));
      }

    });


    // 开启服务
    server.start();
  }
}
