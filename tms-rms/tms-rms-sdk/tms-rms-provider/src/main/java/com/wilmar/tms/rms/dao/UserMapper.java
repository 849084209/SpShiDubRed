package com.wilmar.tms.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wilmar.tms.rms.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(User record);

    /**按照条件查询查看用户详情
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
    
    @Select("select * from RMS_USER")
    List<User> getAll();
}