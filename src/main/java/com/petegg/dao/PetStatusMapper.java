package com.petegg.dao;

import org.apache.ibatis.annotations.Param;

import com.petegg.entity.PetStatus;


/**
 * <p>
 * Title: PetStatusMapper
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
public interface PetStatusMapper extends BaseMapper<PetStatus> {


  /**
   * 
   * <p>
   * Description: 通过pet_info.id 获取宠物状态值
   * </p>
   * 
   * @return
   * @author Peng Yanan
   * @date 2016年8月24日
   */

  PetStatus getByPetId(@Param("petId") long petId);

}
