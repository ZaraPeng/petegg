package petegg.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.redis.UserInfoRedisClient;

/**
 * <p>Title: UserInfoRedisClientTest</p>
 * <p>Description: petegg.redis</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月7日
 */
public class UserInfoRedisClientTest extends BaseTest{
  @Autowired
  private UserInfoRedisClient client;
  
  @Test
  public void testPut(){
    client.put("928b923c-0129-400e-9e3f-3414c2d624f6", "ooF7HjpQBzqZmomwtDDgwMt1mZoc");
  }
  
  @Test
  public void testGet(){
    System.out.println(client.get("928b923c-0129-400e-9e3f-3414c2d624f6"));
    System.out.println(client.get("928b923c-0129-400e-9e3f-3414c2d624f6"));
  }
}

