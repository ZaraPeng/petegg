package com.petegg.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * <p>
 * Title: AbstractRedisClient
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
public class AbstractRedisClient<K, V> {
  @Autowired
  private RedisTemplate<K, V> redisTemplate;
  
  public void put(K k, V v) {
    ValueOperations<K, V> valueOper = redisTemplate.opsForValue();
    valueOper.set(k, v);
  }

  public V get(K k) {
    ValueOperations<K, V> valueOper = redisTemplate.opsForValue();
    return valueOper.get(k);
  }

  public void remove(K k) {
    ValueOperations<K, V> valueOper = redisTemplate.opsForValue();
    RedisOperations<K, V> operations = valueOper.getOperations();
    operations.delete(k);
  }
}
