package com.petegg.socketio.request;

import java.io.Serializable;

/**
 * <p>Title: BaseRequest</p>
 * <p>Description: com.petegg.socketio.request</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月24日
 */
public class BaseRequest implements Serializable{
  
  /** serialVersionUID*/
  private static final long serialVersionUID = 356600797179915046L;
  
  private String petInfoId;// 宠物信息id
  private int actionId; // 动作类型
  public String getPetInfoId() {
    return petInfoId;
  }
  public void setPetInfoId(String petInfoId) {
    this.petInfoId = petInfoId;
  }
  public int getActionId() {
    return actionId;
  }
  public void setActionId(int actionId) {
    this.actionId = actionId;
  }

}

