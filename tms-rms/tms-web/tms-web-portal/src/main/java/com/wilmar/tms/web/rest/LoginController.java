package com.wilmar.tms.web.rest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wilmar.tms.web.common.BaseController;
import com.wilmar.tms.web.common.UniResult;
import com.wilmar.tms.web.param.LoginInParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/v1/login")
@Api(value = "/api/v1/login", description = "登录")
public class LoginController extends BaseController {


	/**登录
	 * @param loginInParam
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UniResult<String> login(@RequestBody@ApiParam(value = "帐号", required = true) LoginInParam loginInParam){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginInParam.getUsername(), loginInParam.getPassword());
		subject.login(token);
		return ok("登陆ok");
	}
	
	/**登出
	 * @return
	 */
	@RequiresAuthentication
	@RequestMapping(value = "/outLogin", method = RequestMethod.GET)
	public UniResult<String> logout(){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated())subject.logout();
		return ok("退出成功");
	}
}
