package com.petegg.netty.domain;

/**
 * <p>
 * Title: ERequestType
 * </p>
 * <p>
 * Description: com.petegg.netty.domain
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月14日
 */
public enum ERequestType {
  SOCKET("socket"), HTTP("http"), WEBSOCKET_TEXT("websocket_text"), WEBSOCKET_BINARY(
      "websocket_binary");

  String value;

  private ERequestType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public static ERequestType parse(String value) {
    for (ERequestType o : values()) {
      if (o.getValue().equals(value)) {
        return o;
      }
    }
    throw new IllegalArgumentException();
  }
}
