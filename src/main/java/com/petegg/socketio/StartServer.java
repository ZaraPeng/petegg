package com.petegg.socketio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: StartServer</p>
 * <p>Description: com.petegg.socketio</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月6日
 */
public class StartServer {

  private static ApplicationContext context;

  /**
   * <p>Description: </p>
   * @param args
   * @author Peng Yanan
   * @date      2016年9月6日
   */
  public static void main(String[] args) {
    context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
    BossEventServer bossEventServer = context.getBean(BossEventServer.class);
    try {
      bossEventServer.start();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

