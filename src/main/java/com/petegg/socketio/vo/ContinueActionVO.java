package com.petegg.socketio.vo;

import java.io.Serializable;

import com.petegg.entity.PetStatus;

/**
 * <p>Title: ContinueActionVO</p>
 * <p>Description: com.petegg.socketio.vo</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月14日
 */
public class ContinueActionVO implements Serializable{
  /** serialVersionUID*/
  private static final long serialVersionUID = -1818191152844401281L;
  
  public PetStatus petStatus;

  public PetStatus getPetStatus() {
    return petStatus;
  }

  public void setPetStatus(PetStatus petStatus) {
    this.petStatus = petStatus;
  }
}

