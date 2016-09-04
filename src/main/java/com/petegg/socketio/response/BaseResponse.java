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
public class BaseResponse implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -2616552769881584041L;

  private int code;
  private String msg = "";
  private long time = System.currentTimeMillis();
  private Object data;

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

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }


}
