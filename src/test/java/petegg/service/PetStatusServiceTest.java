package petegg.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

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

  @Autowired
  private PetStatusService petStatusService;

  @Test
  public void initTest() {
    petStatusService.init(2l);
  }
  
}
