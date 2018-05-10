package com.wilmar.tms.web.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Bowen
 * @Function 根据mergeKey合并多个列表
 */
public class MergedListFactoryBean implements FactoryBean<List<String>> {

	private final static Logger logger = LoggerFactory.getLogger(MergedListFactoryBean.class);

	private List<String> target = new ArrayList<>();

	private List<Map<String, List<String>>> lists;

	/**
	 * @Fields mergeKey : 合并key
	 */
	private String mergeKey;

	/*
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public List<String> getObject() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("merge config list - {}", mergeKey);
		}
		for (Map<String, List<String>> config : lists) {
			List<String> configList = config.get(mergeKey);
			if (configList != null) {
				target.addAll(configList);
				if (logger.isDebugEnabled()) {
					for (String str : configList) {
						logger.debug(str);
					}
				}
			}
		}
		return target;
	}

	/*
	 * @return
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		return target.getClass();
	}

	/*
	 * @return
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	public String getMergeKey() {
		return mergeKey;
	}

	public void setMergeKey(String mergeKey) {
		this.mergeKey = mergeKey;
	}

	public List<Map<String, List<String>>> getLists() {
		return lists;
	}

	public void setLists(List<Map<String, List<String>>> lists) {
		this.lists = lists;
	}

}
