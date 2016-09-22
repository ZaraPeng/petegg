package com.petegg.aop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.petegg.entity.PetStatus;
import com.petegg.enume.ActionEnu;
import com.petegg.service.PetInfoService;
import com.petegg.socketio.vo.LoginVO;

/**
 * <p>
 * Title: LoginAOP
 * </p>
 * <p>
 * Description: com.petegg.aop
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年9月22日
 */
@Component
@Aspect
public class UserLoggerAOP {

  @Autowired
  private PetInfoService petInfoService;

  @Pointcut("execution(public * com.petegg.service.bussiness.LoginEventService.login(..))")
  public void loginPointcut() {}

  @Pointcut("execution(public * com.petegg.service.bussiness.SingleActionEventService.action(..))")
  public void actionPointcut() {}

  /**
   * 
   * <p>
   * Description: 登陆事件
   * </p>
   * 
   * @param pj
   * @param openid
   * @throws Throwable
   * @author Peng Yanan
   * @date 2016年9月22日
   */
  @Around(value = "loginPointcut() &&args(openid) ", argNames = "openid")
  public void interceptorLogin(ProceedingJoinPoint pj, String openid) throws Throwable {
    LoginVO vo = (LoginVO) pj.proceed();
    System.out.println("操作时间： time="
        + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
    System.out.println("用户： openid=" + openid);
    System.out.println("动作：" + "登陆");
    String resultString = JSON.toJSONString(vo);
    System.out.println("返回值：" + resultString);
  }

  /**
   * 
   * <p>
   * Description: 单次动作操作日志
   * </p>
   * 
   * @param pj
   * @param petId
   * @param actionId
   * @throws Throwable
   * @author Peng Yanan
   * @date 2016年9月22日
   */
  @Around(value = "actionPointcut() && args(petId,actionId) ", argNames = "petId,actionId")
  public void interceptorAction(ProceedingJoinPoint pj, long petId, int actionId) throws Throwable {
    PetStatus vo = (PetStatus) pj.proceed();
    // 获取改宠物的用户
    System.out.println("用户：openid=" + petInfoService.getById(petId).getWeixinOpenid());
    System.out.println("操作时间： time=" + currentTime());
    System.out.println("宠物id：petId=" + petId);
    System.out.println("动作:" + ActionEnu.getById(actionId).getMsg());
    String resultString = JSON.toJSONString(vo);
    System.out.println("返回值" + resultString);
  }

  /**
   * 
   * <p>
   * Description: 获取当前时间
   * </p>
   * 
   * @return
   * @author Peng Yanan
   * @date 2016年9月22日
   */
  public String currentTime() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    return dateFormat.format(date);
  }
}
