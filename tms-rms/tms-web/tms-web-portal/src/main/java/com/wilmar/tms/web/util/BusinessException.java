package com.wilmar.tms.web.util;

/**
  * @author 李博文
  * @version 1.0
  * @Function 业务异常
  */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 8109303352556055331L;

    /**
      * @Fields GENERAL_BUSINESS_EXCEPTION : 通用业务异常
      */
    public static String GENERAL_BUSINESS_EXCEPTION = "0000000";

    /**
      * @Fields NULL_ARGUMENT : 请求参数为空异常
      */
    public static final String NULL_ARGUMENT = "0000001";

    /**
      * @Fields ERROR_ADD : 添加失败异常
      */
    public static final String ERROR_ADD = "0000002";

    /**
      * @Fields ERROR_UPDATE : 更新失败异常
      */
    public static final String ERROR_UPDATE = "0000003";

    /**
      * @Fields ERROR_DELETE : 删除失败异常
      */
    public static final String ERROR_DELETE = "0000004";

    /**
      * @Fields ERROR_QUERY : 查询失败异常
      */
    public static final String ERROR_QUERY = "0000005";
    
    /**
     * @Fields ERROR_COPY : 拷贝失败异常
     */
    public static final String ERROR_COPY = "0000006";
    
    /**
     * @Fields ERROR_CONF : 配置失败异常
     */
	public static final String ERROR_CONF = "0000007";
	
	/**
     * @Fields ERROR_UPLOAD : 上传失败
     */
	public static final String ERROR_UPLOAD = "0000008";
	
	/**
     * @Fields ERROR_DOWNLOAD : 下载失败
     */
	public static final String ERROR_DOWNLOAD = "0000009";

    /**
      * @Fields code : 异常代码，7位数字，前3为表示模块/组件，000为common组件，后四位为模块/组件内部异常编号，0000为通用异常。
      *                异常代码对应的异常信息在国际化资源文件中配置，资源文件的key为exception.<code>
      */
    private String code;

    /**
      * 创建一个新的实例 
      * @param code
      * @param message
      * @param e
      */
    public BusinessException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    /**
      * 创建一个新的实例 
      * @param code
      * @param e
      */
    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.code = GENERAL_BUSINESS_EXCEPTION;
    }

    /**
      * 创建一个新的实例 
      * @param e
      */
    public BusinessException(Throwable e) {
        super(e);
        this.code = GENERAL_BUSINESS_EXCEPTION;
    }

    /**
      * 创建一个新的实例 
      * @param code
      * @param message
      */
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
      * 创建一个新的实例 
      * @param code
      */
    public BusinessException(String message) {
        super(message);
        this.code = GENERAL_BUSINESS_EXCEPTION;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
