package petegg.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.petegg.dao.PetInfoMapper;



/**
 * <p>
 * Title: PetInfoDao
 * </p>
 * <p>
 * Description: petegg.dao
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月13日
 */
public class PetInfoDaoTest extends BaseTest{
  
  @Autowired
  private PetInfoMapper petInfoMapper;


  @Test
  public void testGetById() {
    System.out.println(petInfoMapper.getById(1).toString());
  }
  
}
