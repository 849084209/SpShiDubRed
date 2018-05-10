package com.wilmar.tms.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录入参")
public class LoginInParam {
	
	@ApiModelProperty(value = "账户",required=true)
	private String username;
	
	@ApiModelProperty(value = "凭证",required=true,allowableValues = "range[6, 20]")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
