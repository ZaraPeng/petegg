package com.petegg.service.bussiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.petegg.entity.PetStatus;
import com.petegg.entity.PetStatusConfig;
import com.petegg.service.PetStatusConfigService;
import com.petegg.service.PetStatusService;
import com.petegg.util.PetStatusChangeUtils;

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
  
  @Autowired
  private PetStatusConfigService petStatusConfigService;
  
  @Autowired
  private PetStatusChangeUtils changeUtils;

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
  public PetStatus washAction(long petId,int actionId) {
    PetStatus petStatus = petStatusService.getPetStatus(petId);
    logger.info("数据库get obj PetStatus [{}]", JSONObject.toJSONString(petStatus));
    // 通过配置表来更新状态参数
    PetStatusConfig petStatusConfig = petStatusConfigService.getAllConfig().get(1);//actionId=1
    petStatus =changeUtils.change(petStatus, petStatusConfig);
    logger.info("更新之后 {}", JSONObject.toJSONString(petStatus));
    if (petStatusService.update(petStatus))
      logger.info("更新数据成功");// 更新数据
    return petStatusService.getPetStatus(petId);
  }
}
