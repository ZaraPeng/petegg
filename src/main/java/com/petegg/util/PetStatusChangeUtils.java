package com.petegg.util;

import org.springframework.stereotype.Component;

import com.petegg.entity.PetStatus;
import com.petegg.entity.PetStatusConfig;

/**
 * <p>
 * Title: PetStatusChangeUtils
 * </p>
 * <p>
 * Description: com.petegg.util
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月28日
 */
@Component
public class PetStatusChangeUtils {

  /**
   * 
   * <p>
   * Description: 通过状态值配置表更新状态值
   * </p>
   * 
   * @param petStatus
   * @param config
   * @return
   * @author Peng Yanan
   * @date 2016年8月28日
   */
  public PetStatus change(PetStatus petStatus, PetStatusConfig config) {
    petStatus.setActive(petStatus.getActive() + config.getActiveChange());
    petStatus.setClean(petStatus.getClean() + config.getCleanChange());
    petStatus.setEnergy(petStatus.getEnergy() + config.getEnergyChange());
    petStatus.setHappy(petStatus.getHappy() + config.getHappyChange());
    petStatus.setHunger(petStatus.getHunger() + config.getHungerChange());
    petStatus.setSmarts(petStatus.getSmarts() + config.getSmartsChange());
    return petStatus;
  }
}
