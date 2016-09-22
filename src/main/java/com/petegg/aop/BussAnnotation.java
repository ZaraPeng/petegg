package com.petegg.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Title: BussAnnotation
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
 * @date 2016年9月19日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface BussAnnotation {
  public static enum Module {
    LOGIN(1,"登陆"), WASH(2,"洗澡"), EAT_APPLE(3,"吃饭");
    int value;
    String msg;

    Module(int value, String msg) {
      this.value = value;
      this.msg = msg;
    }

  }

  // 模块名
  String moduleName() default "";

  // 操作内容
  String option() default "";
}
