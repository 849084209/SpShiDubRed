package top.bowenlee.notes.constant;

import org.springframework.util.StringUtils;

/**
 * @author libowen1
 *	单位枚举
 */
public enum UserTypeEnum {

	ADMIN("admin","管理员"),
	SUP_ADMIN("supAdmin","超级管理员"),
	OTHER("other","临时、其他");
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
    private UserTypeEnum(String code, String description) {
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
    public static UserTypeEnum getByCode(String code) {
    	if(!StringUtils.isEmpty(code)){
    		for (UserTypeEnum status : values()) {
    			if (code.equalsIgnoreCase(status.getCode())||code.indexOf(status.getCode())!=-1) {
    				return status;
    			}
    		}
    	}
        return null;
    }
    
}
