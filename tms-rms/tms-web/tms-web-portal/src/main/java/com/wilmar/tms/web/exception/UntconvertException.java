package com.wilmar.tms.web.exception;

import com.wilmar.tms.web.common.BusinessException;

/**
 * @author libowen1
 * 单位转换功能
 */
public class UntconvertException extends BusinessException {

	private static final long serialVersionUID = 6580223998720004440L;

	public static final String COMMON = "010106";
	
	public static final String UNTCONVER_COMMON = "010106001";//单位换算分页查询失败
	
	public static final String UNTCONVER_PAGE_ORDER = "010106002";//ORDER参数为空

	public UntconvertException(String message) {
		super(message);
	}

	public UntconvertException(Throwable cause) {
		super(cause);
	}

	public UntconvertException(String message, Throwable cause) {
		super(message, cause);
	}

}
