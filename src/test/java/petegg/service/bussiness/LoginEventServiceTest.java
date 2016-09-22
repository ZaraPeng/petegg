package petegg.service.bussiness;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.service.bussiness.LoginEventService;

/**
 * <p>Title: LoginEventServiceTest</p>
 * <p>Description: petegg.service.bussiness</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月22日
 */
public class LoginEventServiceTest extends BaseTest{

  @Autowired
  private LoginEventService loginEventService;
  
  @Test
  public void aopTest(){
    loginEventService.login("ooF7HjpQBzqZmomwtDDgwMt1mZoc");
  }
}

