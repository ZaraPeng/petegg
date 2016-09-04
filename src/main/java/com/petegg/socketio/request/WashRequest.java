package com.petegg.socketio.request;

import java.io.Serializable;


/**
 * <p>
 * Title: 事件数据
 * </p>
 * <p>
 * Description: com.petegg.socketio
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @param <T>
 * @date 2016年8月23日
 */
public class WashRequest implements Serializable {

  /** serialVersionUID*/
  private static final long serialVersionUID = 5653205035558669957L;

  private long petInfoId;// 宠物信息id
  
  public WashRequest(){
    super();
  }

  public long getPetInfoId() {
    return petInfoId;
  }

  public void setPetInfoId(long petInfoId) {
    this.petInfoId = petInfoId;
  }
  
}
