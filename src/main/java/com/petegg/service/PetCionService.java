package com.petegg.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petegg.dao.PetCionMapper;
import com.petegg.entity.PetCion;

/**
 * <p>
 * Title: PetCoinService
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
 * @date 2016年9月4日
 */
@Component
public class PetCionService extends BaseService<PetCion> {

  @Autowired
  private PetCionMapper petCoinMapper;

  /**
   * 
   * <p>
   * Description: 初始化钱币 by openid
   * </p>
   * 
   * @author Peng Yanan
   * @date 2016年9月4日
   */
  public void init(String openid) {
    PetCion petCion = new PetCion();
    petCion.setWeixinOpenid(openid);
    petCion.setNumber(0);
    petCoinMapper.add(petCion);
  }

  /**
   * 
   * <p>
   * Description: 获取cion个数 通过 openid
   * </p>
   * 
   * @param openid
   * @return
   * @author Peng Yanan
   * @date 2016年9月4日
   */
  public PetCion getByOpenid(String openid) {
    return ObjectUtils.defaultIfNull(petCoinMapper.getByOpenid(openid), new PetCion());
  }
}
