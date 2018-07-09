package com.wilmar.itm.web.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author libowen1
 *
 */
@Component
@Scope("singleton") // 一个Spring容器中只有一个Bean的实例，此为Spring的默认配置，全容器共享一个实例。
public class ShiroData {
	
	/**
	 * 方式
	 */
	@Value("#{shiro['hashAlgorithmName']}")
	private String hashAlgorithmName;
	
	/**
	 * 总次数
	 */
	@Value("#{shiro['hashIterationsAll']}")
	private int hashIterationsAll;
	/**
	 * 后端次数
	 */
	@Value("#{shiro['hashIterations']}")
	private int hashIterations;
	/**
	 * 盐长度
	 */
	@Value("#{shiro['saltSize']}")
	private int saltSize;

	public int getHashIterationsAll() {
		return hashIterationsAll;
	}

	public void setHashIterationsAll(int hashIterationsAll) {
		this.hashIterationsAll = hashIterationsAll;
	}

	/**
	 * @return 盐长度
	 */
	public int getSaltSize() {
		return saltSize;
	}

	public void setSaltSize(int saltSize) {
		this.saltSize = saltSize;
	}

	/**
	 * 方式
	 * @return
	 */
	public String getHashAlgorithmName() {
		return hashAlgorithmName;
	}

	public void setHashAlgorithmName(String hashAlgorithmName) {
		this.hashAlgorithmName = hashAlgorithmName;
	}

	/**
	 * @return 后端次数
	 */
	public int getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	
}
