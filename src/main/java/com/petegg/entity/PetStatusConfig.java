package com.petegg.entity;

import java.io.Serializable;

/**
 * <p>
 * Title: PetStatusConfig
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
 * @date 2016年8月28日
 */
public class PetStatusConfig implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = 8559518315226819069L;

  private long id;
  private int actionId;
  private String actionIdComment;
  private int actionType;
  private String actionTypeComment;
  private long hungerChange;
  private long cleanChange;
  private long smartsChange;
  private long activeChange;
  private long energyChange;
  private long happyChange;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp modifyTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getActionId() {
    return actionId;
  }

  public void setActionId(int actionId) {
    this.actionId = actionId;
  }

  public String getActionIdComment() {
    return actionIdComment;
  }

  public void setActionIdComment(String actionIdComment) {
    this.actionIdComment = actionIdComment;
  }

  public int getActionType() {
    return actionType;
  }

  public void setActionType(int actionType) {
    this.actionType = actionType;
  }

  public String getActionTypeComment() {
    return actionTypeComment;
  }

  public void setActionTypeComment(String actionTypeComment) {
    this.actionTypeComment = actionTypeComment;
  }

  public long getHungerChange() {
    return hungerChange;
  }

  public void setHungerChange(long hungerChange) {
    this.hungerChange = hungerChange;
  }

  public long getCleanChange() {
    return cleanChange;
  }

  public void setCleanChange(long cleanChange) {
    this.cleanChange = cleanChange;
  }

  public long getSmartsChange() {
    return smartsChange;
  }

  public void setSmartsChange(long smartsChange) {
    this.smartsChange = smartsChange;
  }

  public long getActiveChange() {
    return activeChange;
  }

  public void setActiveChange(long activeChange) {
    this.activeChange = activeChange;
  }

  public long getEnergyChange() {
    return energyChange;
  }

  public void setEnergyChange(long energyChange) {
    this.energyChange = energyChange;
  }

  public long getHappyChange() {
    return happyChange;
  }

  public void setHappyChange(long happyChange) {
    this.happyChange = happyChange;
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
    return "PetStatusConfig [id=" + id + ", actionId=" + actionId + ", actionIdComment="
        + actionIdComment + ", actionType=" + actionType + ", actionTypeComment="
        + actionTypeComment + ", hungerChange=" + hungerChange + ", cleanChange=" + cleanChange
        + ", smartsChange=" + smartsChange + ", activeChange=" + activeChange + ", energyChange="
        + energyChange + ", happyChange=" + happyChange + ", createTime=" + createTime
        + ", modifyTime=" + modifyTime + "]";
  }

}
