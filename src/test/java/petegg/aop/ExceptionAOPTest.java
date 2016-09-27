package petegg.aop;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.redis.StringRedisClient;

/**
 * <p>Title: ExceptionAOPTest</p>
 * <p>Description: petegg.aop</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月27日
 */
public class ExceptionAOPTest extends BaseTest{
  @Autowired
  private StringRedisClient client;
  
  @Test
  public void test(){
    client.testxxxx();
  }
}

