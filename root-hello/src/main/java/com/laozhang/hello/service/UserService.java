package com.laozhang.hello.service;

import java.util.List;

import com.laozhang.hello.domain.UserInfo;

public interface UserService {

	UserInfo findOne(int id);
	
	List<UserInfo> findAll();
}
