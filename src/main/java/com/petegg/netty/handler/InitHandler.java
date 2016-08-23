package com.petegg.netty.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.petegg.entity.PetInfo;
import com.petegg.netty.domain.GameRequest;
import com.petegg.netty.domain.GameResponse;
import com.petegg.service.PetInfoService;

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
  
  @Autowired
  private PetInfoService petInfoService;

  public void execute(GameRequest request, GameResponse response) {
      this.logger.info(request.readString());
//      response.write("I am ok!");
      PetInfo petinfo = petInfoService.getById(1);
      response.write(JSONObject.toJSONString(petinfo));
  }
}

