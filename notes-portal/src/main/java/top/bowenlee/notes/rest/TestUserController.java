package top.bowenlee.notes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.bowenlee.notes.common.BaseController;
import top.bowenlee.notes.common.UniResult;
import top.bowenlee.notes.service.TestService;

@RestController
@RequestMapping(value = "/api/v1/Test")
@Api(value = "/api/v1/Test", description = "测试")
public class TestUserController extends BaseController{
	
	
	@Autowired
	private TestService testService;
	
//	@RequiresAuthentication//需要认证通过
	@ApiOperation("测试")
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public UniResult<List<String>> getUser() {
		List<String> test = testService.test();
		return ok(test);
	}
	
}
