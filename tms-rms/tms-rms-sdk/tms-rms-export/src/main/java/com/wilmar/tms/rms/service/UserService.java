package com.wilmar.tms.rms.service;

import java.util.List;

import com.wilmar.tms.rms.common.UniResult;
import com.wilmar.tms.rms.dto.UserDTO;

public interface UserService {
	
	public UniResult<List<UserDTO>> getAll();
	
	/**
	 * 通过ID获取用户详细信息
	 * @param userDtoP
	 * @return
	 */
	public UniResult<UserDTO> selectByPrimaryKey(int id);
}
