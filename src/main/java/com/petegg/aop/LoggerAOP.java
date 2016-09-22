package com.petegg.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

  // 定义切入点 @Pointcut("execution(public * com.jay..*.*(..))") -- 表示对com.jay 包下的所有方法都可添加切入点
  @Pointcut("execution(public * com.petegg.aop.*.addUser(..))")
  public void aApplogic() {}

  // 定义切入点 -- 拦截指定的方法 这里拦截 com.jay.demo3.aop1.impl.UserManagerApplogicImpl 的addOne()方法
  @Pointcut("execution(public * com.petegg.aop.*.addOne(..))")
  public void joinPointForAddOne() {

  }

  /**
   * 环绕通知 用于拦截指定内容，记录用户的操作
   */
  @Around(value = "aApplogic() && @annotation(annotation) &&args(object,..) ",
      argNames = "annotation,object")
  public void interceptorApplogic(ProceedingJoinPoint pj, BussAnnotation annotation, String object)
      throws Throwable {
    System.out.println("moduleName:" + annotation.moduleName());
    System.out.println("option:" + annotation.option());
    String resultString = (String) pj.proceed();
    System.out.println(pj.getSignature().getName());
    for (Object obj : pj.getArgs()) {
      System.out.println(obj.toString());
    }
    System.out.println(resultString);
    System.out.println(object);
  }

  /**
   * 环绕通知 拦截指定的切点，这里拦截joinPointForAddOne切入点所指定的addOne()方法
   * 
   */
  @Around("joinPointForAddOne()")
  public Object interceptorAddOne(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Aop start");
    String methodRemark = getMthodRemark(joinPoint);
    Object result = null;
    try {
      // 记录操作日志...谁..在什么时间..做了什么事情..
      result = joinPoint.proceed();
    } catch (Exception e) {
      // 异常处理记录日志..log.error(e);
      throw e;
    }
    System.out.println(methodRemark);
    System.out.println("Aop end");
    return result;
  }


  // 获取方法的中文备注____用于记录用户的操作日志描述
  public static String getMthodRemark(ProceedingJoinPoint joinPoint) throws Exception {
    String targetName = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    System.out.println("====调用" + methodName + "方法-开始！");
    Object[] arguments = joinPoint.getArgs(); // 获得参数列表
    System.out.println("打印出方法调用时传入的参数，可以在这里通过添加参数的类型，进行一些简易逻辑处理和判断");
    if (arguments.length <= 0) {
      System.out.println("=== " + methodName + " 方法没有参数");
    } else {
      for (int i = 0; i < arguments.length; i++) {
        System.out.println("==== 参数   " + (i + 1) + " : " + arguments[i]);
      }
    }

    Class targetClass = Class.forName(targetName);
    Method[] method = targetClass.getMethods();
    String methode = "";
    for (Method m : method) {
      if (m.getName().equals(methodName)) {
        Class[] tmpCs = m.getParameterTypes();
        if (tmpCs.length == arguments.length) {
          BussAnnotation methodCache = m.getAnnotation(BussAnnotation.class);
          methode = methodCache.moduleName();
          break;
        }
      }
    }
    return methode;
  }
}
