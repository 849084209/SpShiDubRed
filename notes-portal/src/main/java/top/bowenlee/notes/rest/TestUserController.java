package top.bowenlee.notes.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.bowenlee.notes.common.BaseController;
import top.bowenlee.notes.common.UniResult;

@RestController
@RequestMapping(value = "/api/v1/Test")
@Api(value = "/api/v1/Test", description = "测试")
public class TestUserController extends BaseController{
	
//	@RequiresAuthentication//需要认证通过
	@ApiOperation("用户列表")
	@RequestMapping(value = "/TestGetUser", method = RequestMethod.POST)
	public UniResult<String> getUser() {
		return ok("lalalal");
	}
	
}
