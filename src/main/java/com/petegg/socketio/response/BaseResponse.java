package com.petegg.socketio.response;

import java.io.Serializable;

/**
 * <p>
 * Title: BaseResponse
 * </p>
 * <p>
 * Description: com.petegg.socketio.response
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
public class BaseResponse<T> implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -2616552769881584041L;

  private int code;
  private String msg;
  private T data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  
}
