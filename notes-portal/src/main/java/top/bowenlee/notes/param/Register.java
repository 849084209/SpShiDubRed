package top.bowenlee.notes.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("注册")
public class Register {
	
	@ApiModelProperty(value = "昵称",required = true)
	private String name;
	
	@ApiModelProperty(value = "密码",required = true)
	private String pasWord;
	
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
	
}
