package com.petegg.socketio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.petegg.socketio.bussiness.LoginEventServer;
import com.petegg.socketio.bussiness.SingleEventServer;

/**
 * <p>
 * Title: BossEventServer
 * </p>
 * <p>
 * Description: com.petegg.socketio
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年9月4日
 */
@Component
public class BossEventServer {
  
  @Autowired
  private LoginEventServer loginServer;
  
  @Autowired
  private SingleEventServer singleEventServer;

  public void start() throws InterruptedException {
    Configuration config = new Configuration();
    config.setHostname("199.231.214.245");
    config.setPort(9092);

    final SocketIOServer server = new SocketIOServer(config);
    
    //注册服务
    loginServer.listener(server);
    singleEventServer.listener(server);

    // 开启服务
    server.start();
    
    while (true) {
      Thread.sleep(1000);
    }
  }
  
}
