package com.petegg.socketio.request;

import java.io.Serializable;

/**
 * <p>
 * Title: DinnerRequest
 * </p>
 * <p>
 * Description: com.petegg.socketio.request
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
public class DinnerRequest implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -4510088262718438911L;
  private long petInfoId;// 宠物信息id
  private int actionId;// 宠物动作id

  public DinnerRequest() {
    super();
  }

  public int getActionId() {
    return actionId;
  }

  public void setActionId(int actionId) {
    this.actionId = actionId;
  }

  public long getPetInfoId() {
    return petInfoId;
  }

  public void setPetInfoId(long petInfoId) {
    this.petInfoId = petInfoId;
  }
}
