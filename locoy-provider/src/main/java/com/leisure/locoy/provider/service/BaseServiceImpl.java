package com.leisure.locoy.provider.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.leisure.locoy.provider.dao.BaseDao;

public abstract class BaseServiceImpl<T, K extends Serializable> implements BaseService<T, K> {
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 获取DAO操作类
	 */
	public abstract BaseDao<T, K> getDao();

	public int insertEntry(T t) {
		return getDao().insertEntry(t);
	}

	public int insertSelective(T t) {
		return getDao().insertSelective(t);
	}

	public int deleteByPrimaryKey(K key) {
		return getDao().deleteByPrimaryKey(key);
	}
	
	public int deleteByArrayKey(K... keys) {
		return getDao().deleteByArrayKey(keys);
	}

	public int deleteByCondtion(T condition) {
		return getDao().deleteByCondtion(condition);
	}

	public int updateByPrimaryKeySelective(T condition) {
		return getDao().updateByPrimaryKeySelective(condition);
	}


	public T selectByPrimaryKey(K key) {
		return getDao().selectByPrimaryKey(key);
	}

	public List<T> selectEntryArray(K... key) {
		return getDao().selectEntryArray(key);
	}

	public List<T> selectEntryList(T condition) {
		return getDao().selectEntryList(condition);
	}

	public Integer selectEntryListCount(T condition) {
		return getDao().selectEntryListCount(condition);
	}

	

}
