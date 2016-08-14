package petegg.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.service.PetInfoService;

/**
 * <p>Title: PetInfoService</p>
 * <p>Description: petegg.service</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月13日
 */
public class PetInfoServiceTest extends BaseTest{

  @Autowired
  private PetInfoService petInfoService;
  
  @Test
  public void getByidTest(){
    System.out.println(petInfoService.getById(1));
  }
}

