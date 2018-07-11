package top.bowenlee.notes.service;

import java.util.Date;

import top.bowenlee.notes.param.SaveNotes;
import top.bowenlee.notes.param.vo.NotesVO;

public interface NoteService {
	/**
	 * 获取指定时间
	 * @param time
	 * @return 当天Notes
	 */
	public NotesVO getNotes(Date time);

	/**
	 * 保存某天的Notes
	 * @param saveNotes
	 * @return 执行成功
	 */
	public Boolean saveNotes(SaveNotes saveNotes);


}
