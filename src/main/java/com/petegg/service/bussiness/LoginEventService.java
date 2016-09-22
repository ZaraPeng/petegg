package com.petegg.service.bussiness;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petegg.aop.BussAnnotation;
import com.petegg.dao.PetInfoMapper;
import com.petegg.entity.PetInfo;
import com.petegg.entity.PetStatus;
import com.petegg.service.PetCionService;
import com.petegg.service.PetGamerService;
import com.petegg.service.PetStatusService;
import com.petegg.socketio.vo.LoginVO;
import com.petegg.socketio.vo.PetWapperVO;

/**
 * <p>
 * Title: LoginEventService
 * </p>
 * <p>
 * Description: com.petegg.service.bussiness
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年9月4日
 */
@Component
public class LoginEventService {

  @Autowired
  private PetInfoMapper petInfoMapper;

  @Autowired
  private PetGamerService petGamerService;

  @Autowired
  private PetCionService petCionService;

  @Autowired
  private PetStatusService petStatusService;

  /**
   * 
   * <p>
   * Description: 判断用户是否登陆过，返回相应的数据
   * </p>
   * 
   * @param openid
   * @return
   * @author Peng Yanan
   * @date 2016年9月4日
   */
  @BussAnnotation(moduleName="登陆",option="denglu")
  public LoginVO login(String openid) {
    LoginVO result = new LoginVO();
    List<PetInfo> petInfos = petInfoMapper.getByOpenid(openid);
    if (!petInfos.isEmpty()) {
      List<PetWapperVO> petWappeList = new ArrayList<PetWapperVO>();
      PetWapperVO petWapperVO = new PetWapperVO();
      for (PetInfo petInfo : petInfos) {// 包装单个宠物信息和宠物状态
        petWapperVO.setPetInfoId(petInfo.getId());
        petWapperVO.setPetInfo(petInfo);
        PetStatus petStatus = petStatusService.getPetStatus(petInfo.getId());
        petWapperVO.setPetStatus(petStatus);
        petWappeList.add(petWapperVO);
      }
      result.setPetWapperList(petWappeList);

      result.setCionNumber(petCionService.getByOpenid(openid).getNumber());

    } else {// 该微信用户没有登陆过 init数据
      petGamerService.init(openid);// 初始化pet_gamer
      petCionService.init(openid);// 初始化pet_cion

      result.setCionNumber(0);
    }
    return result;
  }
}
