package com.petegg.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.petegg.netty.domain.ERequestType;
import com.petegg.netty.netty.ServerInitializer;

/**
 * <p>
 * Title: NettyServer
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
public class NettyServer {
  private Logger logger = LoggerFactory.getLogger(getClass());
  /** 用于分配处理业务线程的线程组个数 */
  protected static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2;
  /** 业务出现线程大小 */
  protected static final int BIZTHREADSIZE = 4;

  private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
  private static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);

  private ServerInitializer initializer;
  private final int port;

  public NettyServer(int port) {
    this.port = port;
  }

  public void setInitializer(ServerInitializer initializer) {
    this.initializer = initializer;
  }

  public void run() throws Exception {

    try {
      ServerBootstrap b = new ServerBootstrap();
      ((ServerBootstrap) b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class))
          .childHandler(this.initializer);

      Channel ch = null;
      this.logger.info(ERequestType.parse(this.initializer.getRequestType()).getValue()
          + " server started at port " + this.port + '.');

      if (ERequestType.HTTP.equals(ERequestType.parse(this.initializer.getRequestType()))) {
        ch = b.bind(this.port).sync().channel();
      } else
        ch = b.bind(new InetSocketAddress(this.port)).sync().channel();

      ch.closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
