package com.petegg.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * <p>
 * Title: MybatisRedisClient
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
 * @date 2016年8月27日
 */
public class MybatisRedisCache implements Cache {

  @Autowired
  private RedisTemplate<Serializable, Object> redisTemplate;

  @Value("${redis.expireTime}")
  private long expireTime;
  
  /** The ReadWriteLock. */
  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  /**
   * The cache id.
   */
  private final String id;
  
  public MybatisRedisCache(String id){
    this.id=id;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#getId()
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public String getId() {
    // TODO Auto-generated method stub
    return this.id;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#putObject(java.lang.Object, java.lang.Object)
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public void putObject(Object key, Object value) {
    ValueOperations<Serializable, Object> valueOper = redisTemplate.opsForValue();
    valueOper.set((Serializable) key, value, expireTime, TimeUnit.SECONDS);
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#getObject(java.lang.Object)
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public Object getObject(Object key) {
    ValueOperations<Serializable, Object> valueOper = redisTemplate.opsForValue();
    return valueOper.get(key);
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#removeObject(java.lang.Object)
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public Object removeObject(Object key) {
    Object result =getObject(key);
    ValueOperations<Serializable, Object> valueOper = redisTemplate.opsForValue();
    RedisOperations<Serializable, Object> operations = valueOper.getOperations();
    operations.delete((Serializable) key);
    return result;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#clear()
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public void clear() {
    // TODO Auto-generated method stub
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#getSize()
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public int getSize() {
    return Integer.MAX_VALUE;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.apache.ibatis.cache.Cache#getReadWriteLock()
   * @author Peng Yanan
   * @date 2016年8月27日
   */
  @Override
  public ReadWriteLock getReadWriteLock() {
    return readWriteLock;
  }

}
