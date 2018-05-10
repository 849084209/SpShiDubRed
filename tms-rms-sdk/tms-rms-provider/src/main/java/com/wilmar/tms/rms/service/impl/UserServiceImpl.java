package com.wilmar.tms.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.wilmar.tms.rms.dao.UserMapper;
import com.wilmar.tms.rms.domain.User;
import com.wilmar.tms.rms.dto.UserDTO;
import com.wilmar.tms.rms.service.UserService;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserMapper userDao;
	
	@Override
	public List<UserDTO> getAll() {
		List<User> all = userDao.getAll();
		logger.info(JSONObject.toJSONString(all));
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (User user : all) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			result.add(userDTO);
		}
		return result;
	}

}
