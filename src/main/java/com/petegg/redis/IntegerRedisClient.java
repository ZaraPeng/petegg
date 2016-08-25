package com.petegg.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: IntegerRedisClient
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
public class IntegerRedisClient {
  @Autowired
  private RedisTemplate<byte[], byte[]> redisTemplate;

  public void put(String k, String v) {
    ValueOperations<byte[], byte[]> valueOper = redisTemplate.opsForValue();
    valueOper.set(redisTemplate.getStringSerializer().serialize(k), redisTemplate
        .getStringSerializer().serialize(v));
  }

  public String get(String k) {
    ValueOperations<byte[], byte[]> valueOper = redisTemplate.opsForValue();
    return redisTemplate.getStringSerializer().deserialize(valueOper.get(redisTemplate.getStringSerializer().serialize(k)));
  }

}
