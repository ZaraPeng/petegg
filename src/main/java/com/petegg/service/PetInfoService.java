package com.petegg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petegg.dao.PetInfoMapper;
import com.petegg.entity.PetInfo;

/**
 * <p>Title: PetInfoService</p>
 * <p>Description: com.petegg.service</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月13日
 */
@Component
public class PetInfoService extends BaseService<PetInfo>{
  
  @Autowired
  private PetInfoMapper petInfoMapper;
  
  public PetInfo getById(long id){
    return petInfoMapper.getById(id);
  }
}

