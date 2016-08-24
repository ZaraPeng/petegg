package petegg.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.alibaba.fastjson.JSONObject;
import com.petegg.service.PetStatusService;

/**
 * <p>
 * Title: PetStatusServiceTest
 * </p>
 * <p>
 * Description: petegg.service
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
public class PetStatusServiceTest extends BaseTest {

  private Logger logger = LoggerFactory.getLogger(PetStatusServiceTest.class);

  @Autowired
  private PetStatusService petStatusService;

  @Test
  public void initTest() {
    petStatusService.init(2l);
  }

  @Test
  public void washActionTest() {
    logger.info(JSONObject.toJSONString(petStatusService.washAction(1l)));
  }
}
