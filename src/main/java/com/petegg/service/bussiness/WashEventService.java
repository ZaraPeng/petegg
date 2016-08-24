package com.petegg.service.bussiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.petegg.entity.PetStatus;
import com.petegg.service.PetStatusService;

/**
 * <p>
 * Title: WashEventService
 * </p>
 * <p>
 * Description: com.petegg.service.bussiness
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月24日
 */
@Component
public class WashEventService {
  private Logger logger = LoggerFactory.getLogger(WashEventService.class);

  @Autowired
  private PetStatusService petStatusService;

  /**
   * 
   * <p>
   * Description: 洗澡
   * </p>
   * 
   * @param petId
   * @return
   * @author Peng Yanan
   * @date 2016年8月24日
   */
  public PetStatus washAction(long petId) {
    PetStatus obj = petStatusService.getPetStatus(petId);
    logger.info("数据库get obj PetStatus [{}]", JSONObject.toJSONString(obj));
    // TODO 通过配置表来更新状态参数
    obj.setClean(888l);
    obj.setHappy(666l);
    logger.info("更新之后 {}", JSONObject.toJSONString(obj));
    if (petStatusService.update(obj))
      logger.info("更新数据成功");// 更新数据
    return petStatusService.getPetStatus(petId);
  }
}
