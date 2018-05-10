package org.tms.rms.provider;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.wilmar.tms.rms.dao.UserMapper;
import com.wilmar.tms.rms.domain.User;
import com.wilmar.tms.rms.dto.UserDTO;
import com.wilmar.tms.rms.service.UserService;

/**
 * 配置spring和junit整合, junit启动的加载springIOC容器 spring-test, junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring-dao.xml")
public class UserDaoTest {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserMapper userDao;
	@Autowired
	private UserService userService;
	
	@Test
	public void getAll() throws Exception {
		List<User> all = userDao.getAll();
		System.out.println("测试"+JSONObject.toJSONString(all));
	}
	@Test
	public void getAllService() throws Exception {
		List<UserDTO> all = userService.getAll();
		logger.info("测试 输出结果为{}",JSONObject.toJSONString(all));
	}
	
}