package com.petegg.dao;


/**
 * <p>
 * Title: BaseMapper
 * </p>
 * <p>
 * Description: com.petegg.dao
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
public interface BaseMapper<T> {
  /**
   * 
   * <p>
   * Description: 更新
   * </p>
   * 
   * @return
   * @author Peng Yanan
   * @date 2016年8月24日
   */
  int update(T obj);

  /**
   * 
   * <p>
   * Description: 新增
   * </p>
   * 
   * @return
   * @author Peng Yanan
   * @date 2016年8月24日
   */
  int add(T obj);
}
