package com.petegg.socketio.request;

import java.io.Serializable;

/**
 * <p>Title: ContinueActionRequest</p>
 * <p>Description: com.petegg.socketio.request</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月14日
 */
public class ContinueActionRequest implements Serializable{
  
  
  /** serialVersionUID*/
  private static final long serialVersionUID = -8721930248719360623L;
  
  private long petInfoId;// 宠物信息id
  private int actionId;// 宠物动作id
  
  public ContinueActionRequest(){
    super();
  }
  
  public long getPetInfoId() {
    return petInfoId;
  }
  public void setPetInfoId(long petInfoId) {
    this.petInfoId = petInfoId;
  }
  public int getActionId() {
    return actionId;
  }
  public void setActionId(int actionId) {
    this.actionId = actionId;
  }
  
}

