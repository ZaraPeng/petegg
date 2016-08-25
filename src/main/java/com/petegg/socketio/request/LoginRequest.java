package com.petegg.socketio.request;

import java.io.Serializable;

/**
 * <p>
 * Title: LoginRequest
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
 * @date 2016年8月24日
 */
public class LoginRequest implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -3852882219586747725L;

  private String openid;// 微信openid

  public LoginRequest() {
    super();
  }

  public LoginRequest(String openid) {
    this.openid = openid;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }


}
