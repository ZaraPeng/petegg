package com.petegg.service;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.petegg.dao.PetStatusMapper;
import com.petegg.entity.PetStatus;

/**
 * <p>
 * Title: PetStatusService
 * </p>
 * <p>
 * Description: com.petegg.service
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
public class PetStatusService {

  private Logger logger = LoggerFactory.getLogger(PetStatusService.class);

  @Autowired
  private PetStatusMapper petStatusMapper;

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
    PetStatus obj = petStatusMapper.getByPetId(petId);
    logger.info("数据库get {}",JSONObject.toJSONString(obj));
    obj.setClean(800l);
    obj.setHappy(600l);
    logger.info("更新之后 {}",JSONObject.toJSONString(obj));
    if (petStatusMapper.update(obj) > 0)
      logger.info("更新数据成功");// 更新数据
    return getPetStatus(petId);
  }

  /**
   * 
   * <p>
   * Description: 初始化状态值
   * </p>
   * 
   * @return
   * @author Peng Yanan
   * @date 2016年8月24日
   */
  public boolean init(long petId) {
    PetStatus obj = new PetStatus(petId, 1000l, 1000l, 1000l, 1000l, 1000l, 1000l);
    if (petStatusMapper.add(obj) > 0)
      return true;
    return false;
  }

  /**
   * 
   * <p>
   * Description: 通过宠物id获取状态值
   * </p>
   * 
   * @param petId
   * @return
   * @author Peng Yanan
   * @date 2016年8月24日
   */
  public PetStatus getPetStatus(long petId) {
    return ObjectUtils.defaultIfNull(petStatusMapper.getByPetId(petId), new PetStatus());
  }

}
