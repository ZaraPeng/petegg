package com.petegg.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: LoggerAOP
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
 * @date 2016年9月14日
 */

@Component
@Aspect
public class LoggerAOP {

  private Logger logger = LoggerFactory.getLogger(LoggerAOP.class);

  @Before("execution(* com.petegg.redis.*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    logger.info("logBefore() is running!");
    logger.info("hijacked :" + joinPoint.getSignature().getName());
    logger.info("*************");
  }
}
