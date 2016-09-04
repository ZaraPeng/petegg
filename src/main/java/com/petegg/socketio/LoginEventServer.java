package com.petegg.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.petegg.Constants;
import com.petegg.redis.UserInfoRedisClient;
import com.petegg.socketio.request.LoginRequest;
import com.petegg.socketio.response.LoginResponse;

/**
 * <p>
 * Title: LoginEventServer 登陆事件
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
 * @date 2016年8月24日
 */
@Component
public class LoginEventServer {
  private static Logger log = LoggerFactory.getLogger(LoginEventServer.class);
  
  @Autowired
  private UserInfoRedisClient redisClient;

  /**
   * 
   * <p>
   * Description:
   * </p>
   * 
   * @author Peng Yanan
   * @throws InterruptedException 
   * @date 2016年8月24日
   */
  public void listener(final SocketIOServer server) throws InterruptedException {

    // 监听连接事件
    server.addConnectListener(new ConnectListener() {
      @Override
      public void onConnect(SocketIOClient client) {
        // 建立连接 把连接UUID和userID 联系起来
        LoginEventServer.log.info("建立起connect, sessionID={}", client.getSessionId().toString());
        
      }
    });

    // 监听掉线事件
    server.addDisconnectListener(new DisconnectListener() {
      @Override
      public void onDisconnect(SocketIOClient client) {
        LoginEventServer.log.info("断开connect, sessionID={}", client.getSessionId().toString());
        redisClient.remove(client.getSessionId().toString());
      }
    });

    // 监听数据事件
    server.addEventListener("loginEvent", LoginRequest.class, new DataListener<LoginRequest>() {

      @Override
      public void onData(SocketIOClient client, LoginRequest data, AckRequest ackSender)
          throws Exception {
        LoginEventServer.log.info("client[{}] 获取的数据 [{}]", client.getSessionId(),
            JSONObject.toJSONString(data));
        
        //登陆信息加入缓存
        redisClient.put(client.getSessionId().toString(), data.getOpenid());
        
        // 业务逻辑 判断改用户是否登陆过
        
        
        LoginResponse response = new LoginResponse();
        response.setCode(Constants.CODE_SUCCESS);
        response.setMsg("登陆成功");
        // 发送给单独客服端
        server.getClient(client.getSessionId()).sendEvent("loginEvent",
            JSONObject.toJSONString(response));
      }
    });
    
  }
  
}
