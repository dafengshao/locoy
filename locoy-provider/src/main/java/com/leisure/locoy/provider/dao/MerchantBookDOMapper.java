package com.leisure.locoy.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.leisure.locoy.provider.domain.MerchantBookDO;

/**
 * 
 * MerchantBookDOMapper数据库操作接口类
 * @author hewenfeng
 * @date 2018-01-03 23:34:11
 **/

public interface MerchantBookDOMapper extends BaseDao<MerchantBookDO , Long> {
	void insertSelectiveBatch(@Param("list")List<MerchantBookDO> book);

}