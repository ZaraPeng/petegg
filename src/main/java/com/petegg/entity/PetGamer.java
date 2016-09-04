package com.petegg.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * Title: PetGamer
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
 * @date 2016年9月4日
 */
public class PetGamer implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -4004717001306431880L;

  private long id;
  private long petInfoId;
  private String weixinOpenid;
  private String weixinName;
  private String weixinHeadImage;
  private Timestamp createTime;
  private Timestamp modifyTime;

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

  public String getWeixinOpenid() {
    return weixinOpenid;
  }

  public void setWeixinOpenid(String weixinOpenid) {
    this.weixinOpenid = weixinOpenid;
  }

  public String getWeixinName() {
    return weixinName;
  }

  public void setWeixinName(String weixinName) {
    this.weixinName = weixinName;
  }

  public String getWeixinHeadImage() {
    return weixinHeadImage;
  }

  public void setWeixinHeadImage(String weixinHeadImage) {
    this.weixinHeadImage = weixinHeadImage;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Timestamp modifyTime) {
    this.modifyTime = modifyTime;
  }

}
