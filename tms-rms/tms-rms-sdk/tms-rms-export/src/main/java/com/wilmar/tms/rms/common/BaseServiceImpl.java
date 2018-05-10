package com.wilmar.tms.rms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseServiceImpl {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@ExceptionHandler
	public UniResult<Object> exp(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.info("异常是："+ex.getClass());
		UniResult<Object> result = new UniResult<Object>(UniResult.STATUS_ERROR, UniResult.MESSAGE_ERROR, null);
		setMessage(result, ex.getClass().toString());
		return result;
	}
	
	
	/**
	 * ok(通过结果数据，创建一个成功的通用返回结果)
	 * 
	 * @param data
	 * @return
	 */
	public <T> UniResult<T> ok(T data) {
		UniResult<T> result = new UniResult<T>(UniResult.STATUS_OK, UniResult.MESSAGE_OK, data);
		setMessage(result, UniResult.MESSAGE_OK);
		return result;
	}

	/**
	 * ok(创建一个成功的通用返回结果)
	 * 
	 * @return
	 */
	public UniResult<Object> ok() {
		UniResult<Object> result = new UniResult<Object>(UniResult.STATUS_OK, UniResult.MESSAGE_OK, null);
		setMessage(result, UniResult.MESSAGE_OK);
		return result;
	}

	/**
	 * error(创建一个失败的通用返回结果)
	 * 
	 * @return
	 */
	public UniResult<Object> error() {
		UniResult<Object> result = new UniResult<Object>(UniResult.STATUS_ERROR, UniResult.MESSAGE_ERROR, null);
		setMessage(result, UniResult.MESSAGE_ERROR);
		return result;
	}

	public UniResult<Object> error(String errorCode, String messagekey) {
		UniResult<Object> result = new UniResult<Object>(UniResult.STATUS_ERROR, errorCode, messagekey, null);
		setMessage(result, messagekey);
		return result;
	}

	/**
	 * error(指定结果信息，创建一个失败的通用返回结果)
	 * 
	 * @param msg
	 *            结果信息，使用message key能够进行国际化处理
	 * @return
	 */
	public UniResult<Object> error(String messagekey) {
		UniResult<Object> result = new UniResult<Object>(UniResult.STATUS_ERROR, messagekey, null);
		setMessage(result, messagekey);
		return result;
	}

	/**
	 * build(指定结果状态、结果信息，创建一个失败的通用返回结果)
	 * 
	 * @param status
	 * @param msg
	 *            结果信息，使用message key能够进行国际化处理
	 * @return
	 */
	public UniResult<Object> build(Integer status, String message) {
		UniResult<Object> result = new UniResult<Object>(status, message, null);
		setMessage(result, message);
		return result;
	}

	/**
	 * setMessage(设置通用返回结果的结果信息字段，同时进行国际化处理)
	 * 
	 * @param result 通用返回结果
	 * @param message
	 */
	@SuppressWarnings("rawtypes")
	public void setMessage(UniResult result, String message) {
		result.setMsg(message);
	}

	public String getMessage(Exception e) {
		return e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
	}

}
