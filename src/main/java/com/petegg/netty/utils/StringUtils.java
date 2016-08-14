package com.petegg.netty.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Title: StringUtils
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
public class StringUtils {
  public static List<String> splitToStringList(String str, String sepKey) {
    List list = new LinkedList();

    if ((isNotNull(str)) && (isNotNull(sepKey))) {
      String[] items = str.split(sepKey, -1);

      for (String item : items) {
        list.add(item);
      }
    }

    return list;
  }

  public static final boolean isNotNull(String source) {
    return !isNull(source);
  }

  public static final boolean isNull(String source) {
    if ((source != null)
        && ((!source.trim().equals("")) || (!source.trim().equalsIgnoreCase("null")))) {
      return false;
    }

    return true;
  }

  public static String listToString(List<String> stringList) {
    if (stringList == null) {
      return null;
    }
    StringBuilder result = new StringBuilder();
    boolean flag = false;
    for (String string : stringList) {
      if (flag) {
        result.append(",");
      } else {
        flag = true;
      }
      result.append(string);
    }
    return result.toString();
  }
}
