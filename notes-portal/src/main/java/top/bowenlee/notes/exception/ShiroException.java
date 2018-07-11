package top.bowenlee.notes.exception;

import top.bowenlee.notes.common.BusinessException;

public class ShiroException extends BusinessException {
	private static final long serialVersionUID = 5391173935270130045L;

	/**
	 * 没保存上
	 */
	public static final String SAVE = "000000001";
	
	/**
	 * 请检查入参time 因为它转换Date格式失败了
	 */
	public static final String STR2DATA = "000000002";
	
	/**
	 * 入参notes字符串格式不符合规范
	 */
	public static final String NOTES_STR = "000000003";
	
	public ShiroException(String message) {
		super(message);
	}

	public ShiroException(Throwable cause) {
		super(cause);
	}

	public ShiroException(String message, Throwable cause) {
		super(message, cause);
	}

}
