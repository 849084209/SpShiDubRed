package com.wilmar.itm.web.common;

/**
 * @author libowen1
 * 自定义异常Base类
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 8109303352556055331L;

    /**
      * @Fields GENERAL_BUSINESS_EXCEPTION : 通用业务异常
      */
    public static String GENERAL_BUSINESS_EXCEPTION = "000000000";

    /**
      * @Fields NULL_ARGUMENT : 请求参数为空异常
      */
    public static final String NULL_ARGUMENT = "000000001";

    /**
      * @Fields ERROR_ADD : 添加失败异常
      */
    public static final String ERROR_ADD = "000000002";

    /**
      * @Fields ERROR_UPDATE : 更新失败异常
      */
    public static final String ERROR_UPDATE = "000000003";

    /**
      * @Fields ERROR_DELETE : 删除失败异常
      */
    public static final String ERROR_DELETE = "000000004";

    /**
      * @Fields ERROR_QUERY : 查询失败异常
      */
    public static final String ERROR_QUERY = "000000005";
    
    /**
     * @Fields ERROR_COPY : 拷贝失败异常
     */
    public static final String ERROR_COPY = "000000006";
    
    /**
     * @Fields ERROR_CONF : 配置失败异常
     */
	public static final String ERROR_CONF = "000000007";
	
	/**
     * @Fields ERROR_UPLOAD : 上传失败
     */
	public static final String ERROR_UPLOAD = "000000008";
	
	/**
     * @Fields ERROR_DOWNLOAD : 下载失败
     */
	public static final String ERROR_DOWNLOAD = "000000009";
	/**
     * @Fields ERROR_NOLOGIN : 未登陆
     */
	public static final String ERROR_NOLOGIN = "000000010";
	/**
     * @Fields ERROR_USER_NO_DOMAIN : 权限不足
     */
	public static final String ERROR_USER_NO_DOMAIN = "000000011";
	

    /**
      * @Fields code : 异常代码，9位数字，前2为表示项目（00作为通用），3、4两位为模块/组件划分（00作为通用）5、6两位为功能划分（00作为通用），后三位为模块/组件/功能内部异常编号（000为通用异常）。
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
