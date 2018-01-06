package com.leisure.locoy.provider.service;

import java.util.List;

import com.leisure.locoy.provider.domain.MerchantBookDO;



/**
 * 
 * MerchantBookService业务层接口类
 * @author hewenfeng
 * @date 2018-01-03 23:34:11
 **/

public interface MerchantBookService extends BaseService<MerchantBookDO , Long> {

	void insertSelectiveBatch(List<MerchantBookDO> book);
}