package top.bowenlee.notes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import top.bowenlee.notes.exception.ShiroException;

/**
 * 各种小方法 
 * @author libowen1
 *
 */
public class CommonUitl {
	/**
	 * 转换成String 入参格式为Date
	 * 
	 * @param time
	 *            Date
	 * @return
	 */
	public static String getNowDate(Date time) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
		return formatter.format(time);
	}

	/**
	 * 转换成String 入参格式为Date
	 * 
	 * @param time
	 *            Date
	 * @return
	 */
	public static Date getNowDate(String time) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
		try {
			return formatter.parse(time);
		} catch (ParseException e) {
			throw new ShiroException(ShiroException.STR2DATA);
		}
	}
	
	/**检测笔记入参是否符合规范
	 * @param notesStr
	 * @return 
	 * @return
	 */
	public static void checkNotesStr(String notesStr) {
		try {
			String[] notes = notesStr.split(";");
			for (String note : notes) {
				String[] context = note.split("/");
				if(StringUtils.isEmpty(context[0]))throwEX();
				if(StringUtils.isEmpty(context[1])||(Integer.parseInt(context[1])!=0&&Integer.parseInt(context[1])!=1))throwEX();
			}
		} catch (Exception e) {
			throwEX();
		}
	}
	protected static void throwEX() {
		throw new ShiroException(ShiroException.NOTES_STR);
	}
}
