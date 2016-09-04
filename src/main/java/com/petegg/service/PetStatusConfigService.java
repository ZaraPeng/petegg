package com.petegg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petegg.dao.PetStatusConfigMapper;
import com.petegg.entity.PetStatusConfig;

/**
 * <p>
 * Title: PetStatusConfigService
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
 * @date 2016年8月28日
 */
@Component
public class PetStatusConfigService {

  @Autowired
  private PetStatusConfigMapper mapper;

  public Map<Integer, PetStatusConfig> getAllConfig() {
    Map<Integer, PetStatusConfig> map = new HashMap<Integer, PetStatusConfig>();
    List<PetStatusConfig> list= ListUtils.emptyIfNull(mapper.getAllList());
    for (PetStatusConfig obj : list) {
      map.put(obj.getActionId(), obj);
    }
    return map;
  }
}
