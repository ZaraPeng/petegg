package com.petegg.socketio.vo;

import java.io.Serializable;
import java.util.List;

import com.petegg.entity.PetCoin;
import com.petegg.entity.PetInfo;
import com.petegg.entity.PetStatus;

/**
 * <p>Title: LoginVO</p>
 * <p>Description: com.petegg.socketio.vo</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月4日
 */
public class LoginVO implements Serializable{

  /** serialVersionUID*/
  private static final long serialVersionUID = 4625895688945102988L;

  private List<PetInfo> petInfoList;
  private List<PetStatus> petStatutsList;
  private PetCoin petCoin;
  public List<PetInfo> getPetInfoList() {
    return petInfoList;
  }
  public void setPetInfoList(List<PetInfo> petInfoList) {
    this.petInfoList = petInfoList;
  }
  public List<PetStatus> getPetStatutsList() {
    return petStatutsList;
  }
  public void setPetStatutsList(List<PetStatus> petStatutsList) {
    this.petStatutsList = petStatutsList;
  }
  public PetCoin getPetCoin() {
    return petCoin;
  }
  public void setPetCoin(PetCoin petCoin) {
    this.petCoin = petCoin;
  }
  
  
}

