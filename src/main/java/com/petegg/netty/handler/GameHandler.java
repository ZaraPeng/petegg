package com.petegg.netty.handler;

import com.petegg.netty.domain.GameRequest;
import com.petegg.netty.domain.GameResponse;

/**
 * <p>Title: GameHandler</p>
 * <p>Description: com.petegg.netty.handler</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月14日
 */
public abstract interface GameHandler {
  public abstract void execute(GameRequest paramGameRequest, GameResponse paramGameResponse);
}

