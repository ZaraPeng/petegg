package com.petegg.entity;

import java.io.Serializable;

import com.mysql.fabric.xmlrpc.base.Data;

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
  private long petGamerId;
  private String name;
  private float weight;
  private int stage;
  private int type;
  private boolean status;
  private Data createTime;
  private Data modifyTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPetGamerId() {
    return petGamerId;
  }

  public void setPetGamerId(long petGamerId) {
    this.petGamerId = petGamerId;
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

  public Data getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Data createTime) {
    this.createTime = createTime;
  }

  public Data getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Data modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Override
  public String toString() {
    return "PetInfo [id=" + id + ", petGamerId=" + petGamerId + ", name=" + name + ", weight="
        + weight + ", stage=" + stage + ", type=" + type + ", status=" + status + ", createTime="
        + createTime + ", modifyTime=" + modifyTime + "]";
  }

}