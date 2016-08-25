package com.petegg.redis;

import java.io.Serializable;

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
  private RedisTemplate<Serializable, Serializable> redisTemplate;
  
  
  public void put(K k, V v) {
    ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
    valueOper.set((Serializable) k, (Serializable) v);
  }

  @SuppressWarnings("unchecked")
  public V get(K k) {
    ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
    return (V) valueOper.get(k);
  }

  public void remove(K k) {
    ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
    RedisOperations<Serializable, Serializable> operations = valueOper.getOperations();
    operations.delete((Serializable) k);
  }
}
