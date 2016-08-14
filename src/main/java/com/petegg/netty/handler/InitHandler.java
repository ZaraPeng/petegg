package com.petegg.netty.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.petegg.netty.domain.GameRequest;
import com.petegg.netty.domain.GameResponse;

/**
 * <p>Title: InitHandler</p>
 * <p>Description: com.petegg.netty.handler</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月14日
 */
public class InitHandler implements GameHandler{
  protected Logger logger = LoggerFactory.getLogger(getClass());

  public void execute(GameRequest request, GameResponse response) {
      this.logger.error(request.readString());
      response.write("I am ok!");
  }
}

