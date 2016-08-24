package petegg.service.bussiness;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.service.bussiness.WashEventService;

/**
 * <p>
 * Title: WashEventServiceTest
 * </p>
 * <p>
 * Description: petegg.service.bussiness
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月24日
 */
public class WashEventServiceTest extends BaseTest {

  @Autowired
  private WashEventService washEventService;

  @Test
  public void testWashAction() {
    washEventService.washAction(1l);
  }
}
