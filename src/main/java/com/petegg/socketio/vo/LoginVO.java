package com.petegg.socketio.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Title: LoginVO
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
public class LoginVO implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = 4625895688945102988L;

  private List<PetWapperVO> petWapperList;

  private long cionNumber;


  public List<PetWapperVO> getPetWapperList() {
    return petWapperList;
  }

  public void setPetWapperList(List<PetWapperVO> petWapperList) {
    this.petWapperList = petWapperList;
  }

  public long getCionNumber() {
    return cionNumber;
  }

  public void setCionNumber(long cionNumber) {
    this.cionNumber = cionNumber;
  }

}
