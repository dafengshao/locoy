package com.leisure.locoy.provider.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.leisure.locoy.provider.dao.BaseDao;
import com.leisure.locoy.provider.dao.MerchantBookDOMapper;
import com.leisure.locoy.provider.domain.MerchantBookDO;
import com.leisure.locoy.provider.service.BaseServiceImpl;
import com.leisure.locoy.provider.service.MerchantBookService;


/**
 * 
 * MerchantBookServiceImpl业务层实现类
 * @author hewenfeng
 * @date 2018-01-03 23:34:11
 **/

@Service
public class MerchantBookServiceImpl extends BaseServiceImpl<MerchantBookDO, Long> implements MerchantBookService{
	@Resource
	private MerchantBookDOMapper merchantBookDOMapper;

	public BaseDao<MerchantBookDO, Long> getDao(){
		return merchantBookDOMapper;
	}

	@Override
	public void insertSelectiveBatch(List<MerchantBookDO> book) {
		merchantBookDOMapper.insertSelectiveBatch(book);
	}

}