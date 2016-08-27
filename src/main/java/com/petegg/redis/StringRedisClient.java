package com.petegg.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "test", cacheManager = "cacheManager")
public class StringRedisClient {
  Logger logger = LoggerFactory.getLogger(StringRedisClient.class);

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @CachePut(cacheNames = "test", key = "#key")
  public void put(String key, String value) {
    logger.info("excute string redis template put(),key={}", key);
    stringRedisTemplate.opsForValue().set(key, value);
  }

  @Cacheable(cacheNames = "test", key = "#key")
  public String get(String key) {
    logger.info("excute string redis template get(),key={}", key);
    return stringRedisTemplate.opsForValue().get(key);
  }

  @CacheEvict(cacheNames = "test", key = "#key")
  public void remove(String key) {
    stringRedisTemplate.delete(key);
  }

  @Cacheable(value="test", condition="'Joshua'.equals(#name)")
  public String getMessage(String name) {
      System.out.println("Executing HelloServiceImpl" +
                      ".getHelloMessage(\"" + name + "\")");

      return "Hello " + name + "!";
  }

}
