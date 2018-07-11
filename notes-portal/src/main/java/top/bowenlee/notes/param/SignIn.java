package top.bowenlee.notes.param;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.bowenlee.notes.util.CommonUitl;

@ApiModel(value = "称呼和密码")
public class SignIn {
	
	@ApiModelProperty(value = "称呼",example = "dangmin",required = true)
	private String name;
	
	@ApiModelProperty(value = "密码",example="dangmin",allowableValues = "range[6,20)",required = true)
	private String pasWord;
	
	@ApiModelProperty(value = "当前时间",example = "MMdd",required = true)
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasWord() {
		return pasWord;
	}

	public void setPasWord(String pasWord) {
		this.pasWord = pasWord;
	}
	
	public String getKey(){
		return name+pasWord+CommonUitl.getNowDate(time);
	}
	
}
