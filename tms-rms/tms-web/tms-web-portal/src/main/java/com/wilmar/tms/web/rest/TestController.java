package com.wilmar.tms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wilmar.tms.rms.common.UniResult;
import com.wilmar.tms.rms.dto.UserDTO;
import com.wilmar.tms.rms.service.UserService;
import com.wilmar.tms.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author libowen1
 *
 */
@RestController
@RequestMapping(value = "/api/v2/User")
@Api(value = "/api/v1/User", description = "测试DEMO")
public class TestController extends BaseController {
	
	@Autowired
	private UserService userService;
	
//	@RequiresAuthentication//需要认证通过
	@ApiOperation("单位换算列表页")
	@RequestMapping(value = "/getUserAll", method = RequestMethod.POST)
	public UniResult<List<UserDTO>> dataGrid() {
		UniResult<List<UserDTO>> all = userService.getAll();
		return all;
	}
	
}
