package com.petegg.socketio.request;

import java.io.Serializable;

/**
 * <p>Title: SingleActionRequest</p>
 * <p>Description: com.petegg.socketio.request</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月14日
 */
public class SingleActionRequest implements Serializable{
  
  /** serialVersionUID*/
  private static final long serialVersionUID = 6543001748837443287L;
  
  private long petInfoId;// 宠物信息id
  private int actionId;// 宠物动作id
  
  public SingleActionRequest(){
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

