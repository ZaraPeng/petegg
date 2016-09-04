package com.petegg.dao;

import org.apache.ibatis.annotations.Param;

import com.petegg.entity.PetCion;

/**
 * <p>
 * Title: PetCoinMapper
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
 * @date 2016年9月4日
 */
public interface PetCionMapper extends BaseMapper<PetCion> {

  PetCion getByOpenid(@Param("weixinOpenid") String openid);
}
