package com.laozhang.shiro.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.laozhang.shiro.domain.ModuleInfo;
import com.laozhang.shiro.domain.UserInfo;
import com.laozhang.shiro.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ModuleService moduleService;

	@Override
	public UserInfo findByAccount(String account) {
		return userMapper.findByAccount(account);
	}

	@Override
	public Set<String> findPermissions(String account) {
		Set<String> set = Sets.newHashSet();
		UserInfo user = findByAccount(account);
		List<ModuleInfo> modules = moduleService.findModuleByUserId(user.getId());
		
		for (ModuleInfo info : modules) {
			set.add(info.getModuleKey());
		}
		return set;
	}

	@Override
	public List<String> findPermissionUrl(String account) {
		List<String> list = Lists.newArrayList();
		UserInfo user = findByAccount(account);
		List<ModuleInfo> modules = moduleService.findModuleByUserId(user.getId());
		for (ModuleInfo info : modules) {
			if (info.getModuleType() == ModuleInfo.URL_TYPE) {
				list.add(info.getModulePath());
			}
		}
		return list;
	}

}
