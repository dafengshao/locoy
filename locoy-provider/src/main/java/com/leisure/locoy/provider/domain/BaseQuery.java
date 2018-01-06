package com.leisure.locoy.provider.domain;

import java.io.Serializable;

public class BaseQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	protected transient Integer limitIndex;// 开始索引
	protected transient Integer limitSize;// 结束索引
	protected transient String orderBy;
	
	public Integer getLimitIndex() {
		return limitIndex;
	}
	public void setLimitIndex(Integer limitIndex) {
		this.limitIndex = limitIndex;
	}
	public Integer getLimitSize() {
		return limitSize;
	}
	public void setLimitSize(Integer limitSize) {
		this.limitSize = limitSize;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}
