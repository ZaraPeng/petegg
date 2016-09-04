package com.petegg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petegg.dao.PetGamerMapper;
import com.petegg.entity.PetGamer;

/**
 * <p>Title: PetGamerService</p>
 * <p>Description: com.petegg.service</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月4日
 */

@Component
public class PetGamerService extends BaseService<PetGamer>{

  @Autowired
  private PetGamerMapper petGamerMapper;
  
  /**
   * 
   * <p>Description: 初始化pet_gamer 通过openid</p>
   * @param openid
   * @return
   * @author Peng Yanan
   * @date      2016年9月4日
   */
  public void init(String openid){
    PetGamer obj = new PetGamer();
    obj.setWeixinOpenid(openid);
    petGamerMapper.add(obj);
  }
  
}

