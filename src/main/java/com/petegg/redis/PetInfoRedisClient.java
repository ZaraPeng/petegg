package com.petegg.redis;

import org.springframework.stereotype.Component;

import com.petegg.entity.PetInfo;

/**
 * <p>Title: PetInfoRedisClient</p>
 * <p>Description: com.petegg.redis</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月25日
 */
@Component
public class PetInfoRedisClient extends AbstractRedisClient<String, PetInfo>{

}

