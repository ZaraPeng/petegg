package petegg.socketio;

import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.socketio.LoginEventServer;

/**
 * <p>Title: LoginEventServerTest</p>
 * <p>Description: petegg.socketio</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月25日
 */
public class LoginEventServerTest extends BaseTest{

  @Autowired
  private LoginEventServer server;
  
  public void start(){
    server.start();
  }
}

