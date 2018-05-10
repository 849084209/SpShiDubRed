package com.wilmar.tms.web.constant;

/**
 * @author libowen1
 *	单位枚举
 */
public enum ShiroEnum {

	UNLOGIN("UnauthenticatedException","000000010"),
	UNPASSWORD("IncorrectCredentialsException","000000011"),
	UNACCOUNT("UnknownAccountException","000000012"),
	UNAUTHOR("UnauthorizedException","000000013");
	/** 简码 */
    private final String code;

    /** 描述 */
    private final String description;

    /**
     * 私有构造方法
     *
     * @param code          简码
     * @param description   描述
     */
    private ShiroEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code  简码
     * @return      枚举
     */
    public static ShiroEnum getByCode(String code) {
        for (ShiroEnum status : values()) {
            if (code.indexOf(status.getCode())!=-1) {
                return status;
            }
        }
        return null;
    }
    
}
