package com.wilmar.tms.web.constant;

/**
 * @author libowen1
 *
 */
public enum RedisEnum {

	LCCODE("LCCODE","物流中心"),
	WHCODE("WHCODE","仓库");
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
    private RedisEnum(String code, String description) {
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
    public static RedisEnum getByCode(String code) {
        for (RedisEnum status : values()) {
            if (status.getCode().equalsIgnoreCase(code)) {
                return status;
            }
        }
        return null;
    }
}
