package top.bowenlee.notes.constant;

/**
 * @author libowen1
 *	唯一约束键异常
 */
public enum UniqueKeyEnum {

	unique_key("Cause: com.microsoft.sqlserver.jdbc.SQLServerException: Violation of UNIQUE KEY constraint","违反唯一约束键"),
	value_key("(",")"),
	RMS_ROLE_KEY_CODE("RMS_ROLE_KEY_CODE","010000001"),
	RMS_ROLE_KEY_NAME("RMS_ROLE_KEY_NAME","010000002"),
	RMS_USER_KEY_ACCOUNT("RMS_USER_KEY_ACCOUNT","010000003"),
	RMS_USER_ROLE_KEY_UR("RMS_USER_ROLE_KEY_UR","010000004"),
	RMS_SCREEN_KEY_TRCF("RMS_SCREEN_KEY_TRCF","010000005"),
	RMS_ROLE_MENU_KEY_RM("RMS_ROLE_MENU_KEY_RM","010000006"),
	RMS_PERSONALISE_KEY_PFFU("RMS_PERSONALISE_KEY_PFFU","010000007"),
	RMS_PAGE_KEY_CODE("RMS_PAGE_KEY_CODE","010000008"),
	RMS_OPERATION_KEY_CODE("RMS_OPERATION_KEY_CODE","010000009"),
	RMS_MENU_OPE_KEY_MOR("RMS_MENU_OPE_KEY_MOR","010000010"),
	RMS_MENU_KEY_CODE("RMS_MENU_KEY_CODE","010000011"),
	RMS_FIELDS_KEY_CODE("RMS_FIELDS_KEY_CODE","010000012");
	;
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
    private UniqueKeyEnum(String code, String description) {
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
    public static UniqueKeyEnum getByCode(String code) {
        for (UniqueKeyEnum status : values()) {
            if (code.contains(status.getCode())&&status.getCode().contains("_")) {
                return status;
            }
        }
        return null;
    }
    
}
