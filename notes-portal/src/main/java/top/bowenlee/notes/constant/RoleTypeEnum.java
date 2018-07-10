package top.bowenlee.notes.constant;

/**
 * @author libowen1
 *	单位枚举
 */
public enum RoleTypeEnum {

	supManage("supManage","管理"),
	manage("manage","管理"),
	operation("operation","操作");
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
    private RoleTypeEnum(String code, String description) {
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
    public static RoleTypeEnum getByCode(String code) {
        for (RoleTypeEnum status : values()) {
            if (code.indexOf(status.getCode())!=-1) {
                return status;
            }
        }
        return null;
    }
    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code  简码
     * @return      枚举
     */
    public static RoleTypeEnum getByCode2(String code) {
        for (RoleTypeEnum status : values()) {
            if (code.equals(status.getCode())) {
                return status;
            }
        }
        return null;
    }
}
