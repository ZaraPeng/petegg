package com.petegg.socketio.vo;

import java.io.Serializable;

import com.petegg.entity.PetInfo;
import com.petegg.entity.PetStatus;

/**
 * <p>
 * Title: PetWapper
 * </p>
 * <p>
 * Description: com.petegg.socketio.vo
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年9月4日
 */
public class PetWapperVO implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -7258337139662223195L;

  private long petInfoId;
  private PetInfo petInfo;
  private PetStatus petStatus;

  public long getPetInfoId() {
    return petInfoId;
  }

  public void setPetInfoId(long petInfoId) {
    this.petInfoId = petInfoId;
  }

  public PetInfo getPetInfo() {
    return petInfo;
  }

  public void setPetInfo(PetInfo petInfo) {
    this.petInfo = petInfo;
  }

  public PetStatus getPetStatus() {
    return petStatus;
  }

  public void setPetStatus(PetStatus petStatus) {
    this.petStatus = petStatus;
  }

}
