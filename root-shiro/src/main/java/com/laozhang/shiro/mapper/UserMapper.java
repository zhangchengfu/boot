package com.laozhang.shiro.mapper;

import org.apache.ibatis.annotations.Select;

import com.laozhang.shiro.domain.UserInfo;

public interface UserMapper {

	@Select("select * from t_user where account=#{account}")
	UserInfo findByAccount(String account);
}
