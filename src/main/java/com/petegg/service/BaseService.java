package com.petegg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.petegg.dao.BaseMapper;

/**
 * <p>Title: BaseService</p>
 * <p>Description: com.petegg.service</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月24日
 */
public class BaseService<T> {
  
  @Autowired
  private BaseMapper<T> baseMapper;
  
  /**
   * 
   * <p>Description: 新增</p>
   * @param petStatus
   * @return
   * @author Peng Yanan
   * @date      2016年8月24日
   */
  public boolean add(T obj) {
    if (baseMapper.add(obj) > 0)
      return true;
    return false;
  }
  
  /**
   * 
   * <p>Description: 更新</p>
   * @param obj
   * @return
   * @author Peng Yanan
   * @date      2016年8月24日
   */
  public boolean update(T obj){
    if (baseMapper.update(obj) > 0)
      return true;
    return false;
  }
}

