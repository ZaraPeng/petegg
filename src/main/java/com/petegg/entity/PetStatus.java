package com.petegg.entity;

import java.io.Serializable;

/**
 * <p>
 * Title: PetStatus
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
 * @date 2016年8月24日
 */
public class PetStatus implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -7615425170684600523L;

  private long id;
  private long petInfoId; // 宠物信息表id
  private long hunger;// 饥饿值
  private long clean;// 清洁值
  private long smarts;// 智慧值
  private long active;// 活力值
  private long energy;// 体力值
  private long happy;// 开心值
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp modifyTime;

  public PetStatus(){
    
  }
  
  public PetStatus(long petInfoId, long hunger, long clean, long smarts, long active, long energy,
      long happy) {
    this.petInfoId = petInfoId;
    this.hunger = hunger;
    this.clean = clean;
    this.smarts = smarts;
    this.active = active;
    this.energy = energy;
    this.happy = happy;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPetInfoId() {
    return petInfoId;
  }

  public void setPetInfoId(long petInfoId) {
    this.petInfoId = petInfoId;
  }

  public long getHunger() {
    return hunger;
  }

  public void setHunger(long hunger) {
    this.hunger = hunger;
  }

  public long getClean() {
    return clean;
  }

  public void setClean(long clean) {
    this.clean = clean;
  }

  public long getSmarts() {
    return smarts;
  }

  public void setSmarts(long smarts) {
    this.smarts = smarts;
  }

  public long getActive() {
    return active;
  }

  public void setActive(long active) {
    this.active = active;
  }

  public long getEnergy() {
    return energy;
  }

  public void setEnergy(long energy) {
    this.energy = energy;
  }

  public long getHappy() {
    return happy;
  }

  public void setHappy(long happy) {
    this.happy = happy;
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

  @Override
  public String toString() {
    return "PetStatus [id=" + id + ", petInfoId=" + petInfoId + ", hunger=" + hunger + ", clean="
        + clean + ", smarts=" + smarts + ", active=" + active + ", energy=" + energy + ", happy="
        + happy + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
  }


}
