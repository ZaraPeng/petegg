package com.petegg.socketio.response;

import java.io.Serializable;

import com.petegg.entity.PetStatus;

/**
 * <p>Title: PetStatusResponse</p>
 * <p>Description: com.petegg.socketio.response</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月28日
 */
public class PetStatusResponse extends BaseResponse implements Serializable{

  /** serialVersionUID*/
  private static final long serialVersionUID = -3825054672130916102L;
  
  private PetStatus petStatus;

  public PetStatus getPetStatus() {
    return petStatus;
  }

  public void setPetStatus(PetStatus petStatus) {
    this.petStatus = petStatus;
  }
  
}

