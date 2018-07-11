package top.bowenlee.notes.param;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("保存某天的笔记")
public class SaveNotes {
	
	@ApiModelProperty(value = "时间",required = true,example = "Wed Jul 11 19:12:58 CST 2018")
	private Date time;
	
	@ApiModelProperty(value = "笔记字符串,状态 未完成（0）、已完成（1）",required = true,example = "上午吃饭/1;下午蹲坑/1;晚上睡觉/0")
	private String notesStr;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getNotesStr() {
		return notesStr;
	}

	public void setNotesStr(String notesStr) {
		this.notesStr = notesStr;
	}
	
}
