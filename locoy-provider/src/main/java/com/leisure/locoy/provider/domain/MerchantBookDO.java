package com.leisure.locoy.provider.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * 
 * 
 * @author hewenfeng
 * @date 2018-01-03 23:34:11
 **/
@Data
public class MerchantBookDO  extends BaseDomain  {

	private static final long serialVersionUID = 1L;

	
	public MerchantBookDO(){
		createTime = LocalDateTime.now();
		updateTime = createTime;
	}
	/****/
	private String bookName;

	/****/
	private String bookCategory;
	
	private String operateCategory;

	/****/
	private String author;

	/****/
	private String describe;

	/****/
	private Integer bstatus;

	/****/
	private java.time.LocalDate lastUpdateTime;

	/****/
	private JSONObject lastChapter;

	/****/
	private String siteUrl;

	/****/
	private byte[] cover;


	private String coverUrl;
	
	private String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	@Override
	public String toString(){
		return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerchantBookDO other = (MerchantBookDO) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}
	
	
}
