package com.petegg;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * Title: Constants
 * </p>
 * <p>
 * Description: com.petegg
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月24日
 */
public class Constants {

  // 用户登陆信息
  public static Map<UUID, String> userInfoMap = new HashMap<UUID, String>();

  public static int CODE_SUCCESS = 1000;
  public static int CODE_FAIL = 1001;
}
