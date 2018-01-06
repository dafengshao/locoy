package com.leisure.locoy.provider.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * 领域模型基类(常规公共字段)<br/>
 * 一律使用引用类型
 * @author 
 * @since 2014-03-01
 */
public class BaseDomain extends BaseQuery implements Serializable{
	
	private static final long serialVersionUID = -2671530029171920798L;
	protected Long id;
	protected String feature;
	protected LocalDateTime createTime;
	protected LocalDateTime updateTime;
	protected Integer yn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getYn() {
		return yn;
	}
	public void setYn(Integer yn) {
		this.yn = yn;
	}
	@Override
	public String toString() {
		return "BaseDomain [id=" + id + ", feature=" + feature + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", yn=" + yn + "]";
	}
	
	
}
