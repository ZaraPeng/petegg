package com.petegg.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * Title: PetCoin
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
public class PetCion implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = -522557842313159030L;

  private long id;
  private String weixinOpenid;
  private long number;
  private Timestamp createTime;
  private Timestamp modifyTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getWeixinOpenid() {
    return weixinOpenid;
  }

  public void setWeixinOpenid(String weixinOpenid) {
    this.weixinOpenid = weixinOpenid;
  }

  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
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
