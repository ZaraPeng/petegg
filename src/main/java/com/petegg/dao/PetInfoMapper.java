package com.petegg.dao;

import org.apache.ibatis.annotations.Param;

import com.petegg.entity.PetInfo;

/**
 * <p>
 * Title: PetInfoDao
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
 * @date 2016年8月13日
 */
public interface PetInfoMapper {

  PetInfo getById(@Param("id") long id);
}
