package com.petegg.entity;

import java.io.Serializable;

/**
 * <p>
 * Title: PetInfo
 * </p>
 * <p>
 * Description: com.petegg.entity
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月13日
 */
public class PetInfo implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = 6449613218324265655L;

  private long id;
  private String weixinOpenid;
  private String name;
  private float weight;
  private int stage;
  private int type;
  private boolean status;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp modifyTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public int getStage() {
    return stage;
  }

  public void setStage(int stage) {
    this.stage = stage;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

  public java.sql.Timestamp getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(java.sql.Timestamp modifyTime) {
    this.modifyTime = modifyTime;
  }

  public String getWeixinOpenid() {
    return weixinOpenid;
  }

  public void setWeixinOpenid(String weixinOpenid) {
    this.weixinOpenid = weixinOpenid;
  }

}
