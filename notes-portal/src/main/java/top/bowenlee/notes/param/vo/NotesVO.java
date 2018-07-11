package top.bowenlee.notes.param.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("按照日期分割的笔记")
public class NotesVO implements Serializable{
	
	private static final long serialVersionUID = -1547316258366487552L;

	@ApiModelProperty("日期")
	private Date dateTime;
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	@ApiModelProperty("笔记列表")
	private List<NoteVO> note = new ArrayList<NoteVO>();
	
	public List<NoteVO> getNote() {
		return note;
	}
	public void setNote(List<NoteVO> note) {
		this.note = note;
	}
	
}
