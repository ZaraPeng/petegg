package com.petegg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: TestController</p>
 * <p>Description: com.petegg.controller</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月7日
 */
@Controller
@RequestMapping("hello")
public class TestController {

  @RequestMapping("hello")
  @ResponseBody
  public String test(){
    return "helloword";
  }
}

