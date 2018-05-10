package com.wilmar.tms.web.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wilmar.tms.web.constant.ShiroEnum;
import com.wilmar.tms.web.util.BusinessException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author 李博文
 * @version 1.0
 * @Function 类功能说明
 */
@ApiResponses(@ApiResponse(code = 500, message = "业务异常", response = UniResult.class))
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

/*	@Autowired
	private RedisService redisService;*/
	@Autowired
	private ApplicationContext ctx;
	
	/**
	 * exp(将业务异常转换为通用返回结果，并对提示信息做国际化处理)
	 * 
	 * @param request
	 * @param response
	 * @param ex
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	public String exp(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.info("异常是："+ex.getClass());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
//		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		logger.error("Caught controller exception", ex);
		UniResult result = new UniResult();
		if (BusinessException.class.isAssignableFrom(ex.getClass())) {
			try {
				BusinessException bex = (BusinessException) ex;
				String codeKey = "exception." + bex.getCode();
				String messageKey = bex.getMessage();
				String message = ctx.getMessage(codeKey, null,LocaleContextHolder.getLocale());
				if (messageKey != null && messageKey.length() > 0) {
					String additionMessage = ctx.getMessage(messageKey, null,LocaleContextHolder.getLocale());
					message = messageKey + " - " + additionMessage;
				}
				result.setStatus(UniResult.STATUS_ERROR);
//				result.setMsg(string2Unicode(new String(message.getBytes("UTF-8"),"iso-8859-1")));
				result.setMsg(message);
				result.setCode(messageKey);
				String responseStr = result.toJson();
				return responseStr;
			} catch (IOException e) {
				logger.error("response write exception", e);
				return "response write exception";
			}
		} else {
			logger.info("异常是："+ex.getClass().getName()+"  详细："+ex.getMessage());
			try {
				String messageKey = "";
				String message = "";
				if(ShiroEnum.getByCode(ex.getClass().getName())!=null){
					messageKey = ShiroEnum.getByCode(ex.getClass().getName()).getDescription();
					message = ctx.getMessage(messageKey, getErrorMesVal(ex.getMessage()), ex.getMessage(),
							LocaleContextHolder.getLocale());
				}else{
					messageKey = ex.getMessage();
					message = ctx.getMessage(ex.getMessage(), null, ex.getMessage(),
							LocaleContextHolder.getLocale());
				}
				result.setStatus(UniResult.STATUS_ERROR);
				result.setCode(messageKey);
				result.setMsg(message);
				String responseStr = result.toJson();
				return responseStr;
			} catch (IOException e) {
				logger.error("response write exception", e);
				return "response write exception";
			}
		}
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
	 * @param result
	 *            通用返回结果
	 * @param messageKey
	 *            结果信息，若能够作为key找到对应的国际化资源，则进行转换，否则保持不变
	 */
	@SuppressWarnings("rawtypes")
	public void setMessage(UniResult result, String messageKey) {
		String message = ctx.getMessage(messageKey, null, messageKey, LocaleContextHolder.getLocale());
		result.setMsg(message);
	}

	/**
	 * 
	 * getMessage(获取国际化信息)
	 * 
	 * @param messageKey
	 * @return 国际化信息
	 */
	public String getMessage(String messageKey) {
		return ctx.getMessage(messageKey, null, messageKey, LocaleContextHolder.getLocale());
	}

	public String getMessage(Exception e) {
		return e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
	}

	public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为UNICODE
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }
	
	/**
	 * 在异常中截取 权限不足时具体需要的权限值
	 * @param message
	 * @return
	 */
	protected static String[] getErrorMesVal(String message){
        int strStartIndex = message.indexOf("[");  
        int strEndIndex = message.indexOf("]");  
        if (strStartIndex < 0||strEndIndex < 0) {  
            return null;  
        }  
        String[] result = new String[]{message.substring(strStartIndex+1, strEndIndex)};
        return result;  
	}
}
