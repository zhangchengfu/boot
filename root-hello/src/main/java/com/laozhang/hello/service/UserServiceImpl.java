package com.laozhang.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laozhang.hello.domain.UserInfo;
import com.laozhang.hello.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserInfo findOne(int id) {
		return userMapper.findOne(id);
	}

	@Override
	public List<UserInfo> findAll() {
		return userMapper.findAll();
	}

}
