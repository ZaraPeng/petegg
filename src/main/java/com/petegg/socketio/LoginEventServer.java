package com.petegg.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.petegg.Constants;
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
public class LoginEventServer {
  private static Logger log = LoggerFactory.getLogger(LoginEventServer.class);

  /**
   * 
   * <p>
   * Description:
   * </p>
   * 
   * @author Peng Yanan
   * @date 2016年8月24日
   */
  public void start() {
    Configuration config = new Configuration();
    config.setHostname("localhost");
    config.setPort(9092);

    final SocketIOServer server = new SocketIOServer(config);

    // 监听连接事件
    server.addConnectListener(new ConnectListener() {
      @Override
      public void onConnect(SocketIOClient client) {
        // 建立连接 把连接UUID和userID 联系起来
        LoginEventServer.log.info("建立起connect, sessionID={}", client.getSessionId().toString());
        Constants.userInfoMap.put(client.getSessionId(), "");
      }
    });

    // 监听掉线事件
    server.addDisconnectListener(new DisconnectListener() {
      @Override
      public void onDisconnect(SocketIOClient client) {
        LoginEventServer.log.info("断开connect, sessionID={}", client.getSessionId().toString());
        Constants.userInfoMap.remove(client.getSessionId());
      }
    });

    // 监听数据事件
    server.addEventListener("loginEvent", LoginRequest.class, new DataListener<LoginRequest>() {

      @Override
      public void onData(SocketIOClient client, LoginRequest data, AckRequest ackSender)
          throws Exception {
        LoginEventServer.log.info("client[{}] 发送数据 [{}]", client.getSessionId(),
            JSONObject.toJSONString(data));
        Constants.userInfoMap.put(client.getSessionId(), data.getOpenid());

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
