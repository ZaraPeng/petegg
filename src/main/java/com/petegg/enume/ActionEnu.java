package com.petegg.enume;

/**
 * <p>
 * Title: ActionEnu
 * </p>
 * <p>
 * Description: com.petegg.enume
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年9月13日
 */
public enum ActionEnu {

  WASH(1, "洗澡"), DINNER_APPLE(2, "吃苹果");

  private int value;
  private String msg;

  private ActionEnu(int actionId, String msg) {
    this.value = actionId;
    this.msg = msg;
  }

  public int value() {
    return value;
  }

  public String getMsg() {
    return msg;
  }
}
