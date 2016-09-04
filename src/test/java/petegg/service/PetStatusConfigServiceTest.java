package petegg.service;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import petegg.BaseTest;

import com.petegg.dao.PetStatusConfigMapper;
import com.petegg.entity.PetStatusConfig;
import com.petegg.service.PetStatusConfigService;

/**
 * <p>Title: PetStatusConfigServiceTest</p>
 * <p>Description: petegg.service</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月4日
 */
public class PetStatusConfigServiceTest extends BaseTest{

  @Autowired
  private PetStatusConfigService service;
  @Autowired
  private PetStatusConfigMapper mapper;
  
  @Test
  public void test(){
    service.getAllConfig();
  }
  
  @Test
  public void test2(){
    for(PetStatusConfig obj : ListUtils.emptyIfNull(mapper.getAllList())){
      System.out.println(obj.toString());
    }
  }
}

