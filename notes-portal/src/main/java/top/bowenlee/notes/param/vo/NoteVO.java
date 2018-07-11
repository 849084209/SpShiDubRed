package top.bowenlee.notes.param.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("笔记主体")
public class NoteVO {
	
	@ApiModelProperty(value = "内容")
	private String context;
	
	@ApiModelProperty(value = "进行中、完成、未开始、记录（1、2、3、4）")
	private String status;
	
	@ApiModelProperty(value = "时间：0912")
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
