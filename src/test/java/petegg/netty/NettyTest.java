package petegg.netty;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.netty.NettyServer;
import com.petegg.netty.netty.ServerInitializer;

/**
 * <p>
 * Title: NettyTest
 * </p>
 * <p>
 * Description: petegg.netty
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月14日
 */
public class NettyTest extends BaseTest {
  @Autowired
  private ServerInitializer serverInitializer;

  @Test
  public void testRun() throws Exception {
    NettyServer server = new NettyServer(8111);
    server.setInitializer(serverInitializer);
    server.run();
    System.out.println("server is running……");
  }

}
