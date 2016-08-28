package petegg.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.dao.PetStatusConfigMapper;
import com.petegg.entity.PetStatusConfig;

/**
 * <p>
 * Title: PetStatusConfigDaoTest
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
 * @date 2016年8月28日
 */
public class PetStatusConfigDaoTest extends BaseTest {

  @Autowired
  private PetStatusConfigMapper mapper;

  @Test
  public void test() {
    List<PetStatusConfig> list =
        ListUtils.defaultIfNull(mapper.getAllList(), new ArrayList<PetStatusConfig>());

    for (PetStatusConfig obj : list) {
      System.out.println(obj.toString());
    }
  }
}
