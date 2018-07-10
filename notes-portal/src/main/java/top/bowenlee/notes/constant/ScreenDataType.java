package top.bowenlee.notes.constant;

/**
 * @author libowen1
 *	数据权限类型枚举
 */
public enum ScreenDataType {

	GLOBAL("global","全局"),
	PART("part","部分");
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
    private ScreenDataType(String code, String description) {
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
    public static ScreenDataType getByCode(String code) {
        for (ScreenDataType status : values()) {
            if (code.indexOf(status.getCode())!=-1) {
                return status;
            }
        }
        return null;
    }
    
}
