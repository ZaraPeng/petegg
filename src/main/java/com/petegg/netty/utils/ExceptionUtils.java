package com.petegg.netty.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>
 * Title: ExceptionUtils
 * </p>
 * <p>
 * Description: com.petegg.netty.utils
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月14日
 */
public class ExceptionUtils {
  public static String getStackTrace(Exception e) {
    StringWriter writer = new StringWriter();
    e.printStackTrace(new PrintWriter(writer, true));

    return writer.toString();
  }

  public static String getStackTrace(Throwable e) {
    StringWriter writer = new StringWriter();
    e.printStackTrace(new PrintWriter(writer, true));
    return writer.toString();
  }

}
