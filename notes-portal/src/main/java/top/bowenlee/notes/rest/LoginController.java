package top.bowenlee.notes.rest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import top.bowenlee.notes.common.BaseController;
import top.bowenlee.notes.common.UniResult;
import top.bowenlee.notes.param.Register;
import top.bowenlee.notes.param.SignIn;
import top.bowenlee.notes.service.LoginService;

@RestController
@RequestMapping(value = "/api/v1/login")
@Api(value = "/api/v1/login", description = "认证")
public class LoginController extends BaseController{
	
	@Autowired
	private LoginService loginService; 
	
	@ApiOperation("认证")
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public UniResult<String> signIn(@RequestBody@ApiParam(value = "称呼和密码")SignIn signIn) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(signIn.getName(), signIn.getPasWord());
		subject.login(token);
		return ok(subject.getSession().getId().toString());
	}

	@RequiresAuthentication
	@ApiOperation("检验昵称")
	@GetMapping(value = "/checkName")
	public UniResult<Boolean> checkName(@RequestParam@ApiParam(value = "称呼")String name) {
		return ok(loginService.checkName(name));
	}
	
	@ApiOperation("注册")
	@PostMapping(value = "/register")
	public UniResult<Object> register(@RequestBody@ApiParam(value = "昵称和密码")Register register) {
		loginService.register(register);
		return ok();
	}
	
	
	
}
