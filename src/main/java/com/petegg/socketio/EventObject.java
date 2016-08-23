package com.petegg.socketio;

import java.io.Serializable;

/**
 * <p>
 * Title: EventObject
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
public class EventObject implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  private String eventName;//操作类型
  private Object data;//传输的数据

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}
