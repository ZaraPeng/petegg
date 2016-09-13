package petegg.socketio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.petegg.socketio.bussiness.LoginEventServer;

/**
 * <p>
 * Title: LoginEventServerTest
 * </p>
 * <p>
 * Description: petegg.socketio
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月25日
 */
public class LoginEventServerTest extends BaseTest {

  @Autowired
  private LoginEventServer loginServer;

  @Test
  public void start() throws InterruptedException {
    Configuration config = new Configuration();
    config.setHostname("10.0.0.5");
    config.setPort(9092);

    final SocketIOServer server = new SocketIOServer(config);
    loginServer.listener(server);

    // 开启服务
    server.start();

    while (true) {
      Thread.sleep(1000);
    }
  }
}
