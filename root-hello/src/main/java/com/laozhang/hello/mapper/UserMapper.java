package com.laozhang.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.laozhang.hello.domain.UserInfo;

@Mapper
public interface UserMapper {

	@Select(value="select * from boot_user where id=#{id}")
	UserInfo findOne(int id);
	
	List<UserInfo> findAll();
}
