package petegg.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.redis.IntegerRedisClient;
import com.petegg.redis.PetInfoRedisClient;
import com.petegg.redis.StringRedisClient;
import com.petegg.service.PetInfoService;

/**
 * <p>
 * Title: UserInfoRedisClientTest
 * </p>
 * <p>
 * Description: petegg.redis
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
public class PetInfoRedisClientTest extends BaseTest {

  @Autowired
  private PetInfoRedisClient objRedisClient;

  @Autowired
  private IntegerRedisClient intRedis;

  @Autowired
  private StringRedisClient stringRedis;

  @Autowired
  private PetInfoService petService;

  @Test
  public void stringPut() {
    stringRedis.put("woainiya1111", "helloworld");
  }

  @Test
  public void stringGet() {
    System.out.println(stringRedis.get("123456"));
  }

  @Test
  public void intPut() {
    intRedis.put("xx1111xxxxxxxx111111111", "xxxxxxxxx");
  }

  @Test
  public void intGet() {
    System.out.println(intRedis.get("xx1111xxxxxxxx111111111"));
  }

  @Test
  public void remove() {
    // intRedis.remove(100l);
  }

  @Test
  public void objPut() {
    objRedisClient.put("petinfo_id_2", petService.getById(1l));
  }

  @Test
  public void objGet() {
    System.out.println(objRedisClient.get("petinfo_id_2").toString());
  }
  
  @Test
  public void objRemove(){
    objRedisClient.remove("petinfo_id_2");
  }

}
