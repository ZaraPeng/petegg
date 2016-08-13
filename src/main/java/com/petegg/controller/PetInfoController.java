package com.petegg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petegg.entity.PetInfo;
import com.petegg.service.PetInfoService;

/**
 * <p>
 * Title: PetInfoController
 * </p>
 * <p>
 * Description: com.petegg.controller
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
@Controller
@RequestMapping("petInfo")
public class PetInfoController {

  @Autowired
  private PetInfoService petInfoService;

  @RequestMapping("get")
  @ResponseBody
  public PetInfo test() {
    return petInfoService.getById(1);
  }
}
