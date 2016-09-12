package com.petegg.redis;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: UserInfoRedisClient
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
@CacheConfig(cacheNames = "userInfo", cacheManager = "cacheManager")
public class UserInfoRedisClient {
  private Logger log = LoggerFactory.getLogger(UserInfoRedisClient.class);

  @Autowired
  private RedisTemplate<Serializable, Object> redisTemplate;

  @CachePut(cacheNames = "userInfo", key = "#openid")
  public void put(String openid, String uuid) {
    ValueOperations<Serializable, Object> valueOper = redisTemplate.opsForValue();
    valueOper.set(openid, uuid);
    log.info("put object into redis key[openid:{}], value[uuid:{}],", uuid, openid);
  }

  @Cacheable(cacheNames = "userInfo", key = "#openid")
  public String get(String openid) {
    ValueOperations<Serializable, Object> valueOper = redisTemplate.opsForValue();
    log.info("get uuid from redis key[openid :{}]", openid);
    return (String) valueOper.get(openid);
  }

  /**
   * 
   * <p>
   * Description: 清除缓存，不删除redis中数据
   * </p>
   * 
   * @param k
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @CacheEvict(cacheNames = "userInfo", key = "#openid")
  public void remove(String openid) {
    log.info("clear cache key(openid[{}])", openid);
  }
}
