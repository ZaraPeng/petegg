package com.petegg.netty;

import org.springframework.beans.factory.annotation.Autowired;

import com.petegg.netty.netty.ServerInitializer;

/**
 * <p>
 * Title: NettyServerStart
 * </p>
 * <p>
 * Description: com.petegg.netty
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
public class NettyServerStart {
  private static int port;
  @Autowired
  private static ServerInitializer initializer;

  public static void main(String[] args) throws Exception {
    if (args.length > 0)
      port = Integer.parseInt(args[0]);
    else {
      port = 8080;
    }
    run();
  }

  private static void run() throws Exception {
    NettyServer server = new NettyServer(port);
    server.setInitializer(initializer);
    server.run();
    System.out.println("server is running……");
  }
}
