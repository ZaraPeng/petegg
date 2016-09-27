package com.petegg.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: ExceptionHandlerAOP
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
 * @date 2016年9月27日
 */
@Component
@Aspect
public class ExceptionHandlerAOP {

  private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAOP.class);

  @AfterThrowing(pointcut = "execution(* com.petegg.redis.*.*(..))", throwing = "error")
  public void doRecoveryAction2(JoinPoint joinPoint, Exception error) {
    logger.info("*****EXCEPTION HANDLER******");
    logger.info("hijacked : ", joinPoint.getSignature().getName());
    logger.info("Exception : ", error);
    logger.info("****************************");
  }
  
}
