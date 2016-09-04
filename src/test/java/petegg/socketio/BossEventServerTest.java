package petegg.socketio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.socketio.BossEventServer;

/**
 * <p>Title: BossEventServerTest</p>
 * <p>Description: petegg.socketio</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月4日
 */
public class BossEventServerTest extends BaseTest{

  @Autowired
  private BossEventServer server;
  
  @Test
  public void testServer() throws InterruptedException{
    server.start();
  }
  
}

