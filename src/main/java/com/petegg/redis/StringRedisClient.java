package com.petegg.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: StringRedisClient
 * </p>
 * <p>
 * Description: com.petegg.redis
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月25日
 */
@Component
public class StringRedisClient {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public void put(String key, String value) {
    stringRedisTemplate.opsForValue().set(key, value);
  }

  public String get(String key) {
    return stringRedisTemplate.opsForValue().get(key);
  }


}
